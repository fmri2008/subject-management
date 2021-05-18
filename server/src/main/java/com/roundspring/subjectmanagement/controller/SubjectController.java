package com.roundspring.subjectmanagement.controller;

import com.roundspring.subjectmanagement.exception.SubjectEmptyNameException;
import com.roundspring.subjectmanagement.model.Subject;
import com.roundspring.subjectmanagement.service.SubjectService;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subject")
public class SubjectController {

    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @RequestMapping("/register")
    @PostMapping
    public ResponseEntity<String> registerSubject(@RequestBody Subject subject) {
        try {
            subjectService.addSubject(subject);
            return ResponseEntity.ok("Registered subject " + subject.toString());
        } catch (SubjectEmptyNameException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
