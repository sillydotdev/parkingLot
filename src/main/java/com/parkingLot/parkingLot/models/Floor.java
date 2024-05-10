package com.parkingLot.parkingLot.models;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Floor {
    private int floorNumber;
    private Map<VehicleType, Integer> capacity;
    private List<VehicleSpace> spaces;

    public Floor(int floorNumber, Map<VehicleType, Integer> capacity, List<VehicleSpace> spaces) {
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.spaces = spaces;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Map<VehicleType, Integer> getCapacity() {
        return capacity;
    }

    public void setCapacity(Map<VehicleType, Integer> capacity) {
        this.capacity = capacity;
    }

    public List<VehicleSpace> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<VehicleSpace> spaces) {
        this.spaces = spaces;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorNumber=" + floorNumber +
                ", capacity=" + capacity +
                ", spaces=" + spaces +
                '}';
    }
}
