package com.parkingLot.parkingLot.controllers;

import com.parkingLot.parkingLot.entity.Floor;
import com.parkingLot.parkingLot.entity.ParkingLot;
import com.parkingLot.parkingLot.entity.Vehicle;
import com.parkingLot.parkingLot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/parking")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping("/createParkingLot")
    public ResponseEntity<ParkingLot> createParkingLot(@RequestParam int capacity) {
        System.out.println(capacity);
        ParkingLot parkingLot = parkingLotService.createParkingLot(capacity);
        return new ResponseEntity<>(parkingLot, HttpStatus.CREATED);
    }

    @PostMapping("/createFloor")
    public ResponseEntity<Floor> createFloor(@RequestParam Long parkingLotId, @RequestParam int floorNumber,
                                             @RequestParam int capacityCar, @RequestParam int capacityBike,
                                             @RequestParam int capacityBus, @RequestParam int capacityTruck) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(parkingLotId);
        Floor floor = parkingLotService.createFloor(parkingLot, floorNumber, capacityCar, capacityBike, capacityBus, capacityTruck);
        return new ResponseEntity<>(floor, HttpStatus.CREATED);
    }

    @PostMapping("/parkVehicle")
    public ResponseEntity<Vehicle> parkVehicle(@RequestParam String registrationNumber, @RequestParam String vehicleType,
                                               @RequestParam String color, @RequestParam Long floorId) {
        Floor floor = new Floor();
        floor.setId(floorId);
        Vehicle vehicle = parkingLotService.parkVehicle(registrationNumber, vehicleType, color, floor);
        return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }

    @DeleteMapping("/removeVehicle/{vehicleId}")
    public ResponseEntity<Void> removeVehicle(@PathVariable Long vehicleId) {
        parkingLotService.removeVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/checkAvailability")
    public ResponseEntity<String> checkAvailability(@RequestParam Long floorId, @RequestParam String vehicleType) {
        int availability = parkingLotService.checkAvailability(floorId, vehicleType);
        return ResponseEntity.ok("Available spaces for " + vehicleType + " on floor " + floorId + ": " + availability);
    }
}
