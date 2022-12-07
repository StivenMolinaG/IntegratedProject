package com.IntegratedProjectSpring.IntegratedProjectApplication.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentist")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String lastName;
    private String enrollment;

    @OneToOne(mappedBy = "dentist")
    private Turn turn;
    public Dentist() {
    }

    public Dentist(Integer id, String name, String lastName, String enrollment, Turn turn) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.enrollment = enrollment;
        this.turn = turn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public Turn getTurnList() {
        return turn;
    }

    public void setTurnList(Turn turn) {
        this.turn = turn;
    }
}
