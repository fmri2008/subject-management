package com.roundspring.subjectmanagement.service;

import com.roundspring.subjectmanagement.dao.SubjectDao;
import com.roundspring.subjectmanagement.exception.SubjectEmptyNameException;
import com.roundspring.subjectmanagement.exception.SubjectNotExistException;
import com.roundspring.subjectmanagement.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private SubjectDao subjectDao;

    @Autowired
    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public Subject addSubject(Subject subject) {
        if (subject.getFname().isEmpty()) {
            throw new SubjectEmptyNameException("Subject must have a name.");
        }
        return subjectDao.save(subject);
    }

    public Subject updateSubject(Subject subject) {
        if (subject.getId() == null || !subjectDao.existsById(subject.getId())) {
            throw new SubjectNotExistException("Subject Id does not exist.");
        }
        return subjectDao.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return (List<Subject>) subjectDao.findAll();
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectDao.findById(id);
    }
}
