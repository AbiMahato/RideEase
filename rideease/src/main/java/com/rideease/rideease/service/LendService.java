package com.rideease.rideease.service;

import com.rideease.rideease.model.ContactUsModel;
import com.rideease.rideease.model.LendModel;

import java.util.List;

public interface LendService {
    void saveLendDetails(LendModel lend);
    List<LendModel> getLendDetails();
    List<LendModel> searchVehicles(String current_location, String vehicle_type);
}
