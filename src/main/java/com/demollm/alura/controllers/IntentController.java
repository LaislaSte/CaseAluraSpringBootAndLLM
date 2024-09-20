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

import com.demollm.alura.models.bean.Intent;
import com.demollm.alura.models.dto.CreateIntentDTO;
import com.demollm.alura.models.dto.UpdateIntentDTO;
import com.demollm.alura.services.IntentService;

@RestController
@RequestMapping("/intent")
public class IntentController {

    private final IntentService intentService;

    public IntentController(IntentService intentService) {
        this.intentService = intentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Intent> create(@RequestBody CreateIntentDTO createIntentDTO) {
        try {
            Intent savedIntentItem = intentService.create(createIntentDTO);
            return new ResponseEntity<>(savedIntentItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Intent>> list() {
        try {
            List<Intent> list = intentService.list();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Intent> findById(@PathVariable("id") long id) {
        try {
            Intent itemIntent = intentService.findById(id);
            return new ResponseEntity<>(itemIntent, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("CAIU AQUI");
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Intent> update(@RequestBody UpdateIntentDTO updateIntentDTO) {
        try {
            Intent itemIntent = intentService.update(updateIntentDTO);
            return new ResponseEntity<>(itemIntent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Intent> delete(@PathVariable("id") long id) {
        try {
            Intent itemIntent = intentService.deleteById(id);
            return new ResponseEntity<>(itemIntent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
