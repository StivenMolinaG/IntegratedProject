package com.IntegratedProjectSpring.IntegratedProjectApplication.entity;

public class Dentist {

    private int id;
    private String name;
    private String lastName;
    private String enrollment;


    public Dentist() {
    }

    public Dentist(int id, String name, String lastName, String enrollment) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.enrollment = enrollment;
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

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                ", apellido='" + lastName + '\'' +
                ", matricula='" + enrollment + '\'' +
                '}';
    }
}
