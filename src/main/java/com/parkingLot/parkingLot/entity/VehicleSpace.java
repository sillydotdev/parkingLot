package com.parkingLot.parkingLot.entity;

import jakarta.persistence.*;

@Entity
public class VehicleSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int spaceNumber;

    private boolean availability;

    private String vehicleType;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    public VehicleSpace() {
        super();
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public void setSpaceNumber(int spaceNumber) {
        this.spaceNumber = spaceNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "VehicleSpace{" +
                "availability=" + availability +
                ", id=" + id +
                ", spaceNumber=" + spaceNumber +
                ", vehicleType='" + vehicleType + '\'' +
                ", floor=" + floor +
                '}';
    }
}
