package com.rideease.rideease.service;

import com.rideease.rideease.model.ContactUsModel;
import com.rideease.rideease.model.LendModel;

import java.util.List;
import java.util.Optional;

public interface LendService {
    void saveLendDetails(LendModel lend);
    List<LendModel> getLendDetails();
    List<LendModel> searchVehicles(String location, String vehicleType);
    Optional<LendModel> getVehicleById(Long id);
    void deleteVehicleById(Long id);
}
