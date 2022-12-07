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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date dateTime;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id", referencedColumnName = "id")
    private Dentist dentist;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
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

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
