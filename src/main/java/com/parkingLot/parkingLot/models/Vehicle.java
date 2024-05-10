package com.parkingLot.parkingLot.models;

import jakarta.persistence.*;

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registrationNumber;
    private String color;
    private VehicleType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                ", type=" + type +
                '}';
    }
}
