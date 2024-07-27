package com.rideease.rideease.service;

import com.rideease.rideease.model.LendModel;
import com.rideease.rideease.repository.LendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    @Override
    public List<LendModel> searchVehicles(String location, String vehicleType) {
        if (location != null && vehicleType != null) {
            return lendRepository.findByLocationAndVehicleType(location, vehicleType);
        } else if (location != null) {
            return lendRepository.findByLocation(location);
        } else if (vehicleType != null) {
            return lendRepository.findByVehicleType(vehicleType);
        } else {
            return lendRepository.findAll();
        }
    }
    @Override
    public Optional<LendModel> getVehicleById(Long id) {
        return lendRepository.findById(id);

    }
    @Override
    public void deleteVehicleById(Long id) {
        lendRepository.deleteById(id);
    }
}
