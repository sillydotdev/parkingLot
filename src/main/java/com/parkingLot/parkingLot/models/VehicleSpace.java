package com.parkingLot.parkingLot.models;

public class VehicleSpace {
    private int spaceNumber;
    private boolean available;
    private VehicleType type;

    public VehicleSpace(int spaceNumber, boolean available) {
        this.spaceNumber = spaceNumber;
        this.available = available;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public void setSpaceNumber(int spaceNumber) {
        this.spaceNumber = spaceNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VehicleSpace{" +
                "spaceNumber=" + spaceNumber +
                ", available=" + available +
                ", type=" + type +
                '}';
    }
}
