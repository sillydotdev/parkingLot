package com.parkingLot.parkingLot.serviceImplementation;

import com.parkingLot.parkingLot.entity.Floor;
import com.parkingLot.parkingLot.entity.ParkingLot;
import com.parkingLot.parkingLot.entity.Vehicle;
import com.parkingLot.parkingLot.repository.FloorRepository;
import com.parkingLot.parkingLot.repository.ParkingLotRepository;
import com.parkingLot.parkingLot.repository.VehicleRepository;
import com.parkingLot.parkingLot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    // Hourly rates for different vehicle types
    private static final Map<String, Double> HOURLY_RATES = new HashMap<>();
    static {
        HOURLY_RATES.put("bike", 10.0);
        HOURLY_RATES.put("car", 20.0);
        HOURLY_RATES.put("bus", 30.0);
        HOURLY_RATES.put("truck", 30.0); // Assuming same rate for bus and truck
    }
    @Override
    public ParkingLot createParkingLot(int capacity) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCapacity(capacity);
        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public Floor createFloor(ParkingLot parkingLot, int floorNumber, int capacityCar, int capacityBike, int capacityBus, int capacityTruck) {
        Floor floor = new Floor();
        floor.setParkingLot(parkingLot);
        floor.setFloorNumber(floorNumber);
        floor.setCapacityCar(capacityCar);
        floor.setCapacityBike(capacityBike);
        floor.setCapacityBus(capacityBus);
        floor.setCapacityTruck(capacityTruck);
        return floorRepository.save(floor);
    }

    @Override
    public Vehicle parkVehicle(String registrationNumber, String vehicleType, String color, Floor floor) {
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setVehicleType(vehicleType);
        vehicle.setColor(color);
        vehicle.setEntranceTime(new Timestamp(System.currentTimeMillis()));
        vehicle.setFloor(floor);
        // Calculate cost
        double hourlyRate = HOURLY_RATES.getOrDefault(vehicleType, 0.0);
        vehicle.setCost(calculateCost(hourlyRate, vehicle.getEntranceTime()));
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void removeVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle != null) {
            vehicle.setExitTime(new Timestamp(System.currentTimeMillis()));
            vehicleRepository.save(vehicle);
            vehicleRepository.deleteById(vehicleId);
        }
    }

    @Override
    public int checkAvailability(Long floorId, String vehicleType) {
        Optional<Floor> optionalFloor = floorRepository.findById(floorId);
        if (optionalFloor.isPresent()) {
            Floor floor = optionalFloor.get();
            switch (vehicleType) {
                case "car":
                    return floor.getCapacityCar() - floor.getVehicles().size();
                case "bike":
                    return floor.getCapacityBike() - floor.getVehicles().size();
                case "bus":
                    return floor.getCapacityBus() - floor.getVehicles().size();
                case "truck":
                    return floor.getCapacityTruck() - floor.getVehicles().size();
                default:
                    return 0;
            }
        }
        return 0;
    }

    private double calculateCost(double hourlyRate, Timestamp entranceTime) {
        long entranceTimeMillis = entranceTime.getTime();
        long currentTimeMillis = System.currentTimeMillis();
        long durationMillis = currentTimeMillis - entranceTimeMillis;
        double durationHours = durationMillis / (1000.0 * 60 * 60); // Convert milliseconds to hours
        return hourlyRate * durationHours;
    }
}
