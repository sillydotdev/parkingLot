package com.parkingLot.parkingLot.controllers;

import com.parkingLot.parkingLot.models.Vehicle;
import com.parkingLot.parkingLot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.parkingLot.parkingLot.models.VehicleType;


@RestController
@RequestMapping("/parking")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping("/init")
    public void initParkingLot(@RequestParam int totalFloors, @RequestParam int spacesPerFloor) {
        parkingLotService.init(totalFloors, spacesPerFloor);
    }

    @PostMapping("/addVehicle")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        if(parkingLotService.addVehicle(vehicle)) {
            return ResponseEntity.ok("Vehicle added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add vehicle.");
        }
    }

    @DeleteMapping("/removeVehicle/{registrationNumber}")
    public ResponseEntity<String> removeVehicle(@PathVariable String registrationNumber){
        if(parkingLotService.removeVehicle(registrationNumber)) {
            return ResponseEntity.ok("Vehicle removed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to remove vehicle.");
        }
    }

    //    @GetMapping
    @PostMapping("/checkAvailability")
    public int checkAvailability(@RequestParam int floorNumber, @RequestParam VehicleType vehicleType) {
        return parkingLotService.checkAvailability(floorNumber, vehicleType);
    }
}
