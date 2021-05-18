package com.roundspring.subjectmanagement.dao;

import com.roundspring.subjectmanagement.model.Experiment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperimentDao extends CrudRepository<Experiment, Long> {
}
