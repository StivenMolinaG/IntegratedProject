package com.IntegratedProjectSpring.IntegratedProjectApplication.model;
import java.util.Date;

public class Patient {

    private int id;
    private String name;
    private String lastName;
    private Address address;
    private String DNI;
    private Date dateOut;

    public Patient() {
    }

    public Patient(int id, String name, String lastName, Address address, String DNI, Date dateOut) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.DNI = DNI;
        this.dateOut = dateOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", DNI='" + DNI + '\'' +
                ", dateOut=" + dateOut +
                '}';
    }
}