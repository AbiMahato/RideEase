package com.rideease.rideease.repository;

import com.rideease.rideease.model.LendModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LendRepository extends JpaRepository<LendModel,Long> {
    @Query("SELECT l FROM LendModel l WHERE " +
            "(:location IS NULL OR l.currentLocation LIKE %:location%) AND " +
            "(:vehicleType IS NULL OR l.vehicleType = :vehicleType)")
    List<LendModel> findByLocationAndVehicleType(@Param("location") String location,
                                                 @Param("vehicleType") String vehicleType);

    @Query("SELECT l FROM LendModel l WHERE l.currentLocation LIKE %:location%")
    List<LendModel> findByLocation(@Param("location") String location);

    @Query("SELECT l FROM LendModel l WHERE l.vehicleType = :vehicleType")
    List<LendModel> findByVehicleType(@Param("vehicleType") String vehicleType);


}
