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


    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Patient> patientList = new HashSet<>();
    public Dentist() {
    }

    public Dentist(Integer id, String name, String lastName, String enrollment) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.enrollment = enrollment;
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

    @Override
    public String toString() {
        return "Dentist{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", lastName= '" + lastName + '\'' +
                ", enrollment= '" + enrollment + '\'' +
                '}';
    }
}
