package com.roundspring.subjectmanagement.controller;

import com.roundspring.subjectmanagement.model.Experiment;
import com.roundspring.subjectmanagement.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/experiment")
public class ExperimentController {

    private ExperimentService experimentService;

    @Autowired
    public ExperimentController(ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

    @GetMapping
    public List<Experiment> getAllExperiments() {
        return experimentService.getAllExperiments();
    }

    @RequestMapping("register")
    @PostMapping
    public ResponseEntity<String> registerExperiment(@RequestBody Experiment experiment) {
        try {

        } catch () {

        }
    }

}
