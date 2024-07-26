package com.rideease.rideease.controller;

import com.rideease.rideease.dto.LendDto;
import com.rideease.rideease.model.ContactUsModel;
import com.rideease.rideease.model.LendModel;
import com.rideease.rideease.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class LendController {

    private static String uploadFolder = "uploads/";
    @Autowired
    private LendService lendService;

    @GetMapping("/lend")
    public String showLendForm(Model model) {
        model.addAttribute("lend", new LendModel());
        model.addAttribute("page", "lend");
        return "lend";
    }
    @PostMapping("/lend")
    public String submitLendForm(LendDto lendDto, @RequestParam("vehicleImage") MultipartFile vehicleImage ,@RequestParam("citizenshipImage") MultipartFile citizenshipImage ,@RequestParam("insuranceProofImage") MultipartFile insuranceProofImage) throws IOException {
        File directory = new File(uploadFolder);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        byte[] bytesVehicleImage = vehicleImage.getBytes();
        byte[] byteCitizenshipImage = citizenshipImage.getBytes();
        byte[] byteInsuranceProofImage = insuranceProofImage.getBytes();

        Path pathVehicleImage = Paths.get(uploadFolder+vehicleImage.getOriginalFilename());
        Path pathCitizenshipImage = Paths.get(uploadFolder+citizenshipImage.getOriginalFilename());
        Path pathInsuranceProofImage = Paths.get(uploadFolder+insuranceProofImage.getOriginalFilename());

        Files.write(pathVehicleImage,bytesVehicleImage);
        Files.write(pathCitizenshipImage,byteCitizenshipImage);
        Files.write(pathInsuranceProofImage,byteInsuranceProofImage);

        LendModel lendModel = new LendModel();

        lendModel.setVehicleImage("/uploadImage/" + vehicleImage.getOriginalFilename());
        lendModel.setCitizenshipImage("/uploadImage/" + citizenshipImage.getOriginalFilename());
        lendModel.setInsuranceProofImage("/uploadImage/" + insuranceProofImage.getOriginalFilename());

//        lendModel.setVehicleImage(pathVehicleImage.toString());
//        lendModel.setCitizenshipImage(pathCitizenshipImage.toString());
//        lendModel.setInsuranceProofImage(pathInsuranceProofImage.toString());

        lendModel.setName(lendDto.getName());
        lendModel.setEmail(lendDto.getEmail());
        lendModel.setNumber(lendDto.getNumber());
        lendModel.setVehicleName(lendDto.getVehicleName());
        lendModel.setVehicleStatus(lendDto.getVehicleStatus());
        lendModel.setCurrentLocation(lendDto.getCurrentLocation());
        lendModel.setPickUpLocation(lendDto.getPickUpLocation());
        lendModel.setDropOffLocation(lendDto.getDropOffLocation());
        lendModel.setLicencePlateNumber(lendDto.getLicencePlateNumber());
        lendModel.setVehicleType(lendDto.getVehicleType());
        lendModel.setPerDay(lendDto.getPerDay());
        lendModel.setPerHour(lendDto.getPerHour());
        lendModel.setMileage(lendDto.getMileage());
        lendModel.setVehicleDetails(lendDto.getVehicleDetails());


        lendService.saveLendDetails(lendModel);

        return "redirect:/lend";
    }
}
