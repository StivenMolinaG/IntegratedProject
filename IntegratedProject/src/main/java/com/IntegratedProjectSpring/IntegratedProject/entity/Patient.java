package com.IntegratedProjectSpring.IntegratedProject.entity;

import java.sql.Date;

public class Patient {

    private String name;
    private String lastName;
    private String address;
    private String DNI;
    private Date dateOut;

    public Patient() {
    }

    public Patient(String name, String lastName, String address, String DNI, Date dateOut) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.DNI = DNI;
        this.dateOut = dateOut;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + name + '\'' +
                ", apellido='" + lastName + '\'' +
                ", domicilio='" + address + '\'' +
                ", DNI='" + DNI + '\'' +
                ", fechaAlta=" + dateOut +
                '}';
    }
}
