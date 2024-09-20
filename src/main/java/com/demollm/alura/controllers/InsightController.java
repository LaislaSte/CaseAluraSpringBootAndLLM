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

import com.demollm.alura.models.bean.Insight;
import com.demollm.alura.models.dto.CreateInsightDTO;
import com.demollm.alura.models.dto.UpdateInsightDTO;
import com.demollm.alura.services.InsightService;

@RestController
@RequestMapping("/insight")
public class InsightController {

    private final InsightService insightService;

    public InsightController(InsightService insightService) {
        this.insightService = insightService;
    }

    @PostMapping("/create")
    public ResponseEntity<Insight> create(@RequestBody CreateInsightDTO createInsightDTO) {
        try {
            Insight savedInsightItem = insightService.create(createInsightDTO);
            return new ResponseEntity<>(savedInsightItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Insight>> list() {
        try {
            List<Insight> list = insightService.list();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Insight> findById(@PathVariable("id") long id) {
        try {
            Insight itemInsight = insightService.findById(id);
            return new ResponseEntity<>(itemInsight, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("CAIU AQUI");
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Insight> update(@RequestBody UpdateInsightDTO updateInsightDTO) {
        try {
            Insight itemInsight = insightService.update(updateInsightDTO);
            return new ResponseEntity<>(itemInsight, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Insight> delete(@PathVariable("id") long id) {
        try {
            Insight itemInsight = insightService.deleteById(id);
            return new ResponseEntity<>(itemInsight, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
