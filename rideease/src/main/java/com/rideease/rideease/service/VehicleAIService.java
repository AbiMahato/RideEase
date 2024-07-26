package com.rideease.rideease.service;

import com.rideease.rideease.model.VehicleAI;
import com.rideease.rideease.repository.VehicleAIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleAIService {

    @Autowired
    private VehicleAIRepository vehicleAIRepository;

    //FETCH ALL VEHICLE FROM REPOSITORY
    public List<VehicleAI> getAllVehicles() {
        return vehicleAIRepository.findAll();
    }

    // Fetch a specific vehicle by its ID
    public VehicleAI getVehicleById(Long id) {
        return vehicleAIRepository.findById(id).orElse(null);
    }

    // Recommend similar vehicles based on vehicle type and current location
    public List<VehicleAI> recommendSimilarVehicles(VehicleAI selectedVehicle) {
        List<VehicleAI> allVehicles = vehicleAIRepository.findAll();
        return allVehicles.stream()
                .filter(vehicle -> !vehicle.getId().equals(selectedVehicle.getId()))
                .sorted((v1, v2) -> Double.compare(
                        calculateCosineSimilarity(selectedVehicle, v2),
                        calculateCosineSimilarity(selectedVehicle, v1)))
                .collect(Collectors.toList());
    }

    // Calculate cosine similarity between two vehicles
    private double calculateCosineSimilarity(VehicleAI v1, VehicleAI v2) {
        String type1 = v1.getVehicleType();
        String type2 = v2.getVehicleType();
        String location1 = v1.getCurrentLocation();
        String location2 = v2.getCurrentLocation();

        double dotProduct = (type1.equals(type2) ? 1 : 0) + (location1.equals(location2) ? 1 : 0);
        double magnitude1 = Math.sqrt(2); // Since we have 2 fields
        double magnitude2 = Math.sqrt(2); // Since we have 2 fields

        return dotProduct / (magnitude1 * magnitude2);
    }

}






