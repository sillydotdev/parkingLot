package com.parkingLot.parkingLot.repository;

import com.parkingLot.parkingLot.entity.CostStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostStrategyRepository extends JpaRepository<CostStrategy, Long> {
}
