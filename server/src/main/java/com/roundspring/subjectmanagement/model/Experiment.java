package com.roundspring.subjectmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "experiment")
public class Experiment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false, name = "name")
    private String name;

    public Experiment(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Experiment() {}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Experiment Id = " + getId() + "; Experiment name = " + getName();
    }
}
