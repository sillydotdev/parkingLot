package com.parkingLot.parkingLot.repository;

import com.parkingLot.parkingLot.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findVehicleById(Long id);

    Vehicle findByRegistrationId(String registrationNumber);
}
