package com.IntegratedProjectSpring.IntegratedProjectApplication.model;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {

    // TODO: con respecto al id de la tabla, para este trabajo de ejercicio,
    //  te conviene hacer el campo id  autoincremental para la tabla y luego usar el dni
    // como campo de búsqueda si querés. Podrías usar el dni como id, pero requeire de otra estrategia
    // que no vamos a ver
    @Id
    private int id;
    @Column(name = "dni_patient")
    private long DNI;
    private String name;
    private String lastName;
    //private Date dateOut;

  /*  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turn")
    private Set<Turn> turnList = new HashSet<>();*/

    // TODO: revisar diferencias en el mappeo
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address addressReference;

    public Patient() {
    }

    public Patient(long DNI, String name, String lastName, Address addressReference) {
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        //this.dateOut = dateOut;
        //this.turnList = turnList;
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

    /*public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }*/

    /*public Set<Turn> getTurnList() {
        return turnList;
    }

    public void setTurnList(Set<Turn> turnList) {
        this.turnList = turnList;
    }*/

    public Address getAddressReference() {
        return addressReference;
    }

    public void setAddressReference(Address addressReference) {
        this.addressReference = addressReference;
    }
}