package com.parkingLot.parkingLot.entity;

import jakarta.persistence.*;

@Entity
public class CostStrategy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vehicleType;

    @Column(nullable = false)
    private double hourlyRate;

    public CostStrategy() {
        super();
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "CostStrategy{" +
                "hourlyRate=" + hourlyRate +
                ", id=" + id +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
