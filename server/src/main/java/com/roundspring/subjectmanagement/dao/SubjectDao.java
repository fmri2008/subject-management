package com.roundspring.subjectmanagement.dao;

import com.roundspring.subjectmanagement.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends CrudRepository<Subject, Long> {
}
