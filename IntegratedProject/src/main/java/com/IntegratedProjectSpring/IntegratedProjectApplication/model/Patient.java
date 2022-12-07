package com.IntegratedProjectSpring.IntegratedProjectApplication.model;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "dni_patient")
    private Long DNI;
    private String name;
    private String lastName;
    private Date dateOut;


    @OneToOne(mappedBy = "patient")
    private Turn turn;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address addressReference;

    public Patient() {
    }

    public Patient(Long DNI, String name, String lastName, Date dateOut, Address addressReference) {
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        this.dateOut = dateOut;
        //this.turnList = turnList;
        this.addressReference = addressReference;
    }

    public Patient(Long DNI, String name, String lastName, Date dateOut) {
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        this.dateOut = dateOut;
    }

    public Patient(Integer id, Long DNI, String name, String lastName, Address addressReference) {
        this.id = id;
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        this.addressReference = addressReference;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
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

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }
/*
    public Set<Turn> getTurnList() {
        return turnList;
    }

    public void setTurnList(Set<Turn> turnList) {
        this.turnList = turnList;
    }
*/
    public Address getAddressReference() {
        return addressReference;
    }

    public void setAddressReference(Address addressReference) {
        this.addressReference = addressReference;
    }
}