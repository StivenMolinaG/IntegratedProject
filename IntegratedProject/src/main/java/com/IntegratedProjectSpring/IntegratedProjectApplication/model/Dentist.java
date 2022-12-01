package com.IntegratedProjectSpring.IntegratedProjectApplication.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentist")
public class Dentist {

    @Id
    @Column(name = "id_dentist")
    private Integer id;
    private String name;
    private String lastName;
    private String enrollment;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turn")
    private Set<Turn> turnList = new HashSet<>();

    public Dentist() {
    }

    public Dentist(Integer id, String name, String lastName, String enrollment, Set<Turn> turnList) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.enrollment = enrollment;
        this.turnList = turnList;
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

    public Set<Turn> getTurnList() {
        return turnList;
    }

    public void setTurnList(Set<Turn> turnList) {
        this.turnList = turnList;
    }
}
