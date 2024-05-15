package com.parkingLot.parkingLot;

import com.parkingLot.parkingLot.entity.Floor;
import com.parkingLot.parkingLot.entity.ParkingLot;
import com.parkingLot.parkingLot.entity.Vehicle;
import com.parkingLot.parkingLot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotApplication {

	@Autowired
	private ParkingLotService parkingLotService;

	public static void main(String[] args) {

		SpringApplication.run(ParkingLotApplication.class, args);

		// Initialize Spring Boot application context
		ParkingLotApplication app = new ParkingLotApplication();

		// Simulate parking and unparking operations
		app.simulateParkingOperations();
	}

	public void simulateParkingOperations() {
		// Create a parking lot with a capacity of 100
		ParkingLot parkingLot = parkingLotService.createParkingLot(100);

		// Create a floor with capacity for cars, bikes, buses, and trucks
		Floor floor = parkingLotService.createFloor(parkingLot, 1, 50, 20, 10, 20);

		// Park a vehicle
		Vehicle vehicle1 = parkingLotService.parkVehicle("ABC123", "car", "red", floor);
		System.out.println("Vehicle parked with ID: " + vehicle1.getId());

		// Park another vehicle
		Vehicle vehicle2 = parkingLotService.parkVehicle("XYZ456", "bike", "blue", floor);
		System.out.println("Vehicle parked with ID: " + vehicle2.getId());

		// Unpark a vehicle
		parkingLotService.removeVehicle(vehicle1.getId());
		System.out.println("Vehicle with ID " + vehicle1.getId() + " unparked.");

		// Check availability after unparking
		int availability = parkingLotService.checkAvailability(floor.getId(), "car");
		System.out.println("Available car spaces on floor " + floor.getFloorNumber() + ": " + availability);
	}
}
