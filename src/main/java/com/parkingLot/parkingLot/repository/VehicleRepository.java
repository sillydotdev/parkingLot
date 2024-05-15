package com.parkingLot.parkingLot.repository;

import com.parkingLot.parkingLot.entity.Vehicle;
import com.parkingLot.parkingLot.entity.VehicleSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<VehicleSpace> findByFloorId(Long floorId);
}
