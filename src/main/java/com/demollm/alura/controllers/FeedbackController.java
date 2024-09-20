package com.demollm.alura.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demollm.alura.models.bean.Feedback;
import com.demollm.alura.models.dto.CreateFeedbackDTO;
import com.demollm.alura.models.dto.UpdateFeedbackDTO;
import com.demollm.alura.services.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/create")
    public ResponseEntity<Feedback> create(@RequestBody CreateFeedbackDTO createFeedbackDTO) {
        try {
            Feedback savedFeedbackItem = feedbackService.create(createFeedbackDTO);
            return new ResponseEntity<>(savedFeedbackItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Feedback>> list() {
        try {
            List<Feedback> list = feedbackService.list();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Feedback> findById(@PathVariable("id") long id) {
        try {
            Feedback itemFeedback = feedbackService.findById(id);
            return new ResponseEntity<>(itemFeedback, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("CAIU AQUI");
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Feedback> update(@RequestBody UpdateFeedbackDTO updateFeedbackDTO) {
        try {
            Feedback itemFeedback = feedbackService.update(updateFeedbackDTO);
            return new ResponseEntity<>(itemFeedback, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Feedback> delete(@PathVariable("id") long id) {
        try {
            Feedback itemFeedback = feedbackService.deleteById(id);
            return new ResponseEntity<>(itemFeedback, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
