package com.rideease.rideease.repository;

import com.rideease.rideease.model.LendModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LendRepository extends JpaRepository<LendModel,Long> {
    @Query("SELECT l FROM LendModel l WHERE l.currentLocation = :current_location AND l.vehicleType = :vehicle_type")
    List<LendModel> findByCurrentLocationAndVehicleType(@Param("current_location")String currentLocation, @Param("vehicle_type") String vehicleType);

}
