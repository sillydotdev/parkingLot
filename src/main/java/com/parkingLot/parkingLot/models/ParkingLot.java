package com.parkingLot.parkingLot.models;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Floor> floors;

    public ParkingLot(List<Floor> floors) {
        this.floors = floors;
    }


    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "floors=" + floors +
                '}';
    }
}
