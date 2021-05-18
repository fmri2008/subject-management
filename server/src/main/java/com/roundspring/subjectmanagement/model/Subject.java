package com.roundspring.subjectmanagement.model;

import javax.persistence.*;

@Entity
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "fname")
    private String fname;

    public Subject(Long id, String fname) {
        this.id = id;
        this.fname = fname;
    }

    public Subject() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return "Primary Id: " + getId() + " fname: " + getFname();
    }
}
