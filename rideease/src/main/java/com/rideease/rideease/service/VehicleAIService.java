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

    public List<LendModel> getAllVehicles() {
        return lendRepository.findAll();
    }

    public LendModel getVehicleById(Long id) {
        return lendRepository.findById(id).orElse(null);
    }

    public List<LendModel> recommendSimilarVehicles(LendModel selectedVehicle) {
        List<LendModel> allVehicles = lendRepository.findAll();
        return allVehicles.stream()
                .filter(vehicle -> !vehicle.getId().equals(selectedVehicle.getId()))
                .sorted((v1, v2) -> Double.compare(
                        calculateCosineSimilarity(selectedVehicle, v2),
                        calculateCosineSimilarity(selectedVehicle, v1)))
                .collect(Collectors.toList());
    }


    private double calculateCosineSimilarity(LendModel v1, LendModel v2) {
        // Convert vehicle attributes to vectors
        double[] vector1 = convertVehicleToVector(v1);
        double[] vector2 = convertVehicleToVector(v2);

        // Calculate dot product
        double dotProduct = 0;
        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
        }

        // Calculate magnitudes
        double magnitude1 = calculateMagnitude(vector1);
        double magnitude2 = calculateMagnitude(vector2);

        // Calculate cosine similarity
        return dotProduct / (magnitude1 * magnitude2);
    }

    // Convert vehicle attributes to a numerical vector
    private double[] convertVehicleToVector(LendModel vehicle) {
        String type = vehicle.getVehicleType();
        String location = vehicle.getCurrentLocation();
        String name = vehicle.getVehicleName();

        return new double[]{
                type.hashCode(),
                location.hashCode(),
                name.hashCode()
        };
    }

    // Calculate the magnitude of a vector
    private double calculateMagnitude(double[] vector) {
        double sum = 0;
        for (double v : vector) {
            sum += v * v;
        }
        return Math.sqrt(sum);
    }
}
