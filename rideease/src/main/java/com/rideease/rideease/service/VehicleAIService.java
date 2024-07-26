package com.rideease.rideease.service;

import com.rideease.rideease.model.LendModel;
import com.rideease.rideease.repository.LendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleAIService {

    @Autowired
    private LendRepository lendRepository;

    //FETCH ALL VEHICLE FROM REPOSITORY
    public List<LendModel> getAllVehicles() {
        return lendRepository.findAll();
    }

    // Fetch a specific vehicle by its ID
    public LendModel getVehicleById(Long id) {
        return lendRepository.findById(id).orElse(null);
    }

    // Recommend similar vehicles based on vehicle type and current location
    public List<LendModel> recommendSimilarVehicles(LendModel selectedVehicle) {
        List<LendModel> allVehicles = lendRepository.findAll();
        return allVehicles.stream()
                .filter(vehicle -> !vehicle.getId().equals(selectedVehicle.getId()))
                .sorted((v1, v2) -> Double.compare(
                        calculateCosineSimilarity(selectedVehicle, v2),
                        calculateCosineSimilarity(selectedVehicle, v1)))
                .collect(Collectors.toList());
    }

    // Calculate cosine similarity between two vehicles
    private double calculateCosineSimilarity(LendModel v1, LendModel v2) {
        String type1 = v1.getVehicleType();
        String type2 = v2.getVehicleType();
        String location1 = v1.getCurrentLocation();
        String location2 = v2.getCurrentLocation();
        String name1 = v1.getVehicleName();
        String name2 = v2.getVehicleName();
        String status1 = v1.getVehicleStatus();
        String status2 = v2.getVehicleStatus();

        double dotProduct = 0;
        dotProduct += (type1.equals(type2) ? 1 : 0);
        dotProduct += (location1.equals(location2) ? 1 : 0);
        dotProduct += (name1.equals(name2) ? 1 : 0);
        dotProduct += (status1.equals(status2) ? 1 : 0);

        // Calculate magnitudes
        double magnitude1 = Math.sqrt(4); // Since we have 4 fields
        double magnitude2 = Math.sqrt(4); // Since we have 4 fields

        // Calculate cosine similarity
        return dotProduct / (magnitude1 * magnitude2);
    }


}






