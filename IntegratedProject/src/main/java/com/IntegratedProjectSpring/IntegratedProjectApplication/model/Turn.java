package com.IntegratedProjectSpring.IntegratedProjectApplication.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "turn")
public class Turn {

    @Id
    @Column(name = "id_turn")
    private Integer id;
    private Date dateTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dni_patient")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dentist")
    private Dentist dentist;

    public Turn() {
    }

    public Turn(Integer id, Date dateTime, Patient patient, Dentist dentist) {
        this.id = id;
        this.dateTime = dateTime;
        this.patient = patient;
        this.dentist = dentist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Patient getPatientList() {
        return patient;
    }

    public void setPatientList(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentistList() {
        return dentist;
    }

    public void setDentistList(Dentist dentist) {
        this.dentist = dentist;
    }
}
