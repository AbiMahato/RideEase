package com.rideease.rideease.controller;


import com.rideease.rideease.model.VehicleAI;
import com.rideease.rideease.service.VehicleAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleAIController {

    @Autowired
    private VehicleAIService vehicleAIService;


    // Show the form to select a vehicle
    @GetMapping("/vehicle")
    public String showVehicleForm(Model model) {
        List<VehicleAI> vehicles = vehicleAIService.getAllVehicles();
        model.addAttribute("vehicles", vehicles);
        return "user/vehicle";
    }

    // Handle form submission and recommend similar vehicles
    @PostMapping("/selectVehicle")
    public String recommendSimilarVehicles(@RequestParam("selectedVehicleId") Long selectedVehicleId, Model model) {
        VehicleAI selectedVehicle = vehicleAIService.getVehicleById(selectedVehicleId);
        List<VehicleAI> recommendations = vehicleAIService.recommendSimilarVehicles(selectedVehicle);
        model.addAttribute("recommendations", recommendations);
        return "user/recommendations";
    }
}
