package com.IntegratedProjectSpring.IntegratedProjectApplication.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "dni_patient")
    private long DNI;
    private String name;
    private String lastName;
    private Integer address;
    private Date dateOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address addressReference;

    public Patient() {
    }

    public Patient(long DNI, String name, String lastName, Integer address, Date dateOut) {
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.dateOut = dateOut;
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

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "DNI=" + DNI +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", dateOut=" + dateOut +
                '}';
    }
}