package com.roundspring.subjectmanagement.service;

import com.roundspring.subjectmanagement.dao.ExperimentDao;
import com.roundspring.subjectmanagement.exception.ExperimentEmptyNameException;
import com.roundspring.subjectmanagement.exception.ExperimentNotExistException;
import com.roundspring.subjectmanagement.model.Experiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperimentService {

    private ExperimentDao experimentDao;

    @Autowired
    public ExperimentService(ExperimentDao experimentDao) {
        this.experimentDao = experimentDao;
    }

    public Experiment addExperiment(Experiment experiment) {
        if (experiment.getName().isEmpty()) {
            throw new ExperimentEmptyNameException("Experiment must have a name.");
        }
        return experimentDao.save(experiment);
    }

    public Experiment updateExperiment(Experiment experiment) {
        if (experiment.getId() == null || !experimentDao.existsById(experiment.getId())) {
            throw new ExperimentNotExistException("Experiment does not exist.");
        }
        return experimentDao.save(experiment);
    }

    public List<Experiment> getAllExperiments() {
        return (List<Experiment>) experimentDao.findAll();
    }

    public Optional<Experiment> getExperimentById(Long id) {
        return experimentDao.findById(id);
    }
}
