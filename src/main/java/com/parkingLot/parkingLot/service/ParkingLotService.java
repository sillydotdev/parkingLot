package com.parkingLot.parkingLot.service;

import com.parkingLot.parkingLot.entity.Floor;
import com.parkingLot.parkingLot.entity.ParkingLot;
import com.parkingLot.parkingLot.entity.Vehicle;

public interface ParkingLotService {

    public ParkingLot createParkingLot(int capacity);
    public Floor createFloor(ParkingLot parkingLot, int floorNumber, int capacityCar, int capacityBike, int capacityBus, int capacityTruck);
    public Vehicle parkVehicle(String registrationNumber, String vehicleType, String color, Floor floor);
    public void removeVehicle(Long vehicleId);
    public int checkAvailability(Long floorId, String vehicleType);

}
