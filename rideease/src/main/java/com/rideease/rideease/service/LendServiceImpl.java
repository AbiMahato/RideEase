package com.rideease.rideease.service;

import com.rideease.rideease.model.LendModel;
import com.rideease.rideease.repository.LendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendServiceImpl implements LendService {
    @Autowired
    private LendRepository lendRepository;

    @Override
    public void saveLendDetails(LendModel lend){
        lendRepository.save(lend);
    }
    public List<LendModel> getLendDetails(){
        return lendRepository.findAll();
    }

    public List<LendModel> searchVehicles(String current_location, String vehicle_type) {
        return lendRepository.findByCurrentLocationAndVehicleType(current_location, vehicle_type);
    }
}
