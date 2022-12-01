package com.IntegratedProjectSpring.IntegratedProjectApplication.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "address_id")
    private Integer id;
    private String street;
    private String number;
    private String location;
    private String province;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_reference", referencedColumnName = "address_id")
    private Patient patient;
    public Address() {
    }

    public Address(Integer id, String street, String number, String location, String province) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", location='" + location + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
