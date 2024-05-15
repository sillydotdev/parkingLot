package com.parkingLot.parkingLot.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int floorNumber;

    private int capacityCar;

    private int capacityBike;

    private int capacityBus;

    private int capacityTruck;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    @OneToMany(mappedBy = "floor")
    private List<Vehicle> vehicles;

    public Floor() {
        super();
    }

    public int getCapacityBike() {
        return capacityBike;
    }

    public void setCapacityBike(int capacityBike) {
        this.capacityBike = capacityBike;
    }

    public int getCapacityBus() {
        return capacityBus;
    }

    public void setCapacityBus(int capacityBus) {
        this.capacityBus = capacityBus;
    }

    public int getCapacityCar() {
        return capacityCar;
    }

    public void setCapacityCar(int capacityCar) {
        this.capacityCar = capacityCar;
    }

    public int getCapacityTruck() {
        return capacityTruck;
    }

    public void setCapacityTruck(int capacityTruck) {
        this.capacityTruck = capacityTruck;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "capacityBike=" + capacityBike +
                ", id=" + id +
                ", floorNumber=" + floorNumber +
                ", capacityCar=" + capacityCar +
                ", capacityBus=" + capacityBus +
                ", capacityTruck=" + capacityTruck +
                ", parkingLot=" + parkingLot +
                ", vehicles=" + vehicles +
                '}';
    }
}
