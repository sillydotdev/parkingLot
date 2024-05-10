package com.parkingLot.parkingLot.service;

import com.parkingLot.parkingLot.models.Vehicle;
import com.parkingLot.parkingLot.models.VehicleType;

public interface ParkingLotService {
    void init(int totalFloors, int spacesPerFloor);
    boolean addVehicle(Vehicle vehicle);
    boolean removeVehicle(String registrationNumber);
    int checkAvailability(int floorNumber, VehicleType vehicleType);
}
