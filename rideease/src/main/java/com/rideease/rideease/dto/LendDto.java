package com.rideease.rideease.dto;

import org.springframework.web.multipart.MultipartFile;

public class LendDto {
    private String name;
    private String email;
    private String number;
    private String vehicleName;
    private String vehicleStatus;
    private String currentLocation;
    private String pickUpLocation;
    private String dropOffLocation;
    private String LicencePlateNumber;
    private String vehicleType;
    private float perDay;
    private float perHour;
    private MultipartFile vehicleImage;
    private MultipartFile  citizenshipImage;
    private MultipartFile insuranceProofImage;
    private String mileage;
    private String vehicleDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getLicencePlateNumber() {
        return LicencePlateNumber;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        LicencePlateNumber = licencePlateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public float getPerDay() {
        return perDay;
    }

    public void setPerDay(float perDay) {
        this.perDay = perDay;
    }

    public float getPerHour() {
        return perHour;
    }

    public void setPerHour(float perHour) {
        this.perHour = perHour;
    }

    public MultipartFile getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(MultipartFile vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public MultipartFile getCitizenshipImage() {
        return citizenshipImage;
    }

    public void setCitizenshipImage(MultipartFile citizenshipImage) {
        this.citizenshipImage = citizenshipImage;
    }

    public MultipartFile getInsuranceProofImage() {
        return insuranceProofImage;
    }

    public void setInsuranceProofImage(MultipartFile insuranceProofImage) {
        this.insuranceProofImage = insuranceProofImage;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }
}
