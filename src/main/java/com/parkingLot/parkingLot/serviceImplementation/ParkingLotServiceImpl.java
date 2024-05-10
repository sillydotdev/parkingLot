package com.parkingLot.parkingLot.serviceImplementation;

import com.parkingLot.parkingLot.models.*;
import com.parkingLot.parkingLot.repository.VehicleRepository;
import com.parkingLot.parkingLot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    private ParkingLot parkingLot;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public ParkingLotServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public void init(int totalFloors, int spacesPerFloor) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 1; i <= totalFloors; i++) {
            Map<VehicleType, Integer> capacity = new HashMap<>();
            for (VehicleType type : VehicleType.values()) {
                capacity.put(type, spacesPerFloor);
            }
            List<VehicleSpace> spaces = new ArrayList<>();
            for (int j = 1; j <= spacesPerFloor; j++) {
                spaces.add(new VehicleSpace(j, true)); // Assuming all spaces are initially available
            }
            floors.add(new Floor(i, capacity, spaces));
        }
        parkingLot = new ParkingLot(floors);
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
            try {
                vehicleRepository.save(vehicle);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
    }

    @Override
    public boolean removeVehicle(String registrationNumber) {
        Vehicle vehicle = vehicleRepository.findByRegistrationId(registrationNumber);
        if (vehicle != null) {
            vehicleRepository.delete(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public int checkAvailability(int floorNumber, VehicleType vehicleType) {
        Optional<Floor> optionalFloor = parkingLot.getFloors().stream()
                .filter(floor -> floor.getFloorNumber() == floorNumber)
                .findFirst();
        if (optionalFloor.isPresent()) {
            Floor floor = optionalFloor.get();
            int availableSpaces = (int) floor.getSpaces().stream()
                    .filter(space -> space.isAvailable() && space.getType() == vehicleType)
                    .count();
            return availableSpaces;
        }
        return 0;
    }


}
