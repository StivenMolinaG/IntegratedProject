package com.IntegratedProjectSpring.IntegratedProjectApplication.model;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "dni_patient")
    private long DNI;
    private String name;
    private String lastName;
    private Date dateOut;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turn")
    private Set<Turn> turnList = new HashSet<>();

    @OneToOne(mappedBy = "patient")
    private Address addressReference;

    public Patient() {
    }

    public Patient(long DNI, String name, String lastName, Date dateOut, Set<Turn> turnList, Address addressReference) {
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        this.dateOut = dateOut;
        this.turnList = turnList;
        this.addressReference = addressReference;
    }

    public long getDNI() {
        return DNI;
    }

    public void setDNI(long DNI) {
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

    public Set<Turn> getTurnList() {
        return turnList;
    }

    public void setTurnList(Set<Turn> turnList) {
        this.turnList = turnList;
    }

    public Address getAddressReference() {
        return addressReference;
    }

    public void setAddressReference(Address addressReference) {
        this.addressReference = addressReference;
    }
}