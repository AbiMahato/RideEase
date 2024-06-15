package com.rideease.rideease.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Lend")
public class LendModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private String vehicleImage;
    private String CitizenshipImage;
    private String InsuranceProofImage;
    private String vehicleDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
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

    public String getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(String vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public String getCitizenshipImage() {
        return CitizenshipImage;
    }

    public void setCitizenshipImage(String citizenshipImage) {
        CitizenshipImage = citizenshipImage;
    }

    public String getInsuranceProofImage() {
        return InsuranceProofImage;
    }

    public void setInsuranceProofImage(String insuranceProofImage) {
        InsuranceProofImage = insuranceProofImage;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }
}
