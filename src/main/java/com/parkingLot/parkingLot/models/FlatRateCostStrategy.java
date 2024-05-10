package com.parkingLot.parkingLot.models;
import com.parkingLot.parkingLot.models.VehicleType;


public class FlatRateCostStrategy implements CostStrategy{
    private static final double BIKE_RATE = 10.0;
    private static final double CAR_RATE = 20.0;
    private static final double BUS_TRUCK_RATE = 30.0;

    @Override
    public double calculateCost(int durationHours) {
        double totalCost = 0.0;
        // Implement flat rate calculation based on vehicle type
        // For simplicity, assuming durationHours as total hours parked
        switch (type) {
            case BIKE:
                totalCost = durationHours * BIKE_RATE;
                break;
            case CAR:
                totalCost = durationHours * CAR_RATE;
                break;
            case BUS:
            case TRUCK:
                totalCost = durationHours * BUS_TRUCK_RATE;
                break;
        }
        return totalCost;
    }
}
