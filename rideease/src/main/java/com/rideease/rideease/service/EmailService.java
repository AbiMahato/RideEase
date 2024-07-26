package com.rideease.rideease.service;

import com.rideease.rideease.model.LendModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public static final String TO="nisan11prajapati@gmail.com";



    //Method to send email
    public void sendEmail(String customerEmail,String number, Optional<LendModel> vehicle) {



        if (vehicle.isPresent()) {
            LendModel abc = vehicle.get();

            String subject="RideEase";
            String message="Dear Customer.You have booked vehicle from Ride Ease. " +
                    "\n Vehicle Name: "+abc.getVehicleName()+
                    "\n Phone Number : "+abc.getNumber()+
                    "\n Vehicle Location: "+abc.getCurrentLocation()+
                    "\n Vehicle Condition: "+abc.getVehicleStatus()+
                    "\n Vehicle Cost per Day: "+abc.getPerDay()+
                    "\n Vehicle Details: "+abc.getVehicleDetails();


            String subject1="RideEase";
            String message1="Your vehicle have been booked by "+customerEmail + "\nPhone number: "+number;

            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(customerEmail);
            email.setSubject(subject);
            email.setText(message);

            SimpleMailMessage email1 = new SimpleMailMessage();
            email1.setTo(abc.getEmail());
            email1.setSubject(subject1);
            email1.setText(message1);

            mailSender.send(email);
            mailSender.send(email1);
        } else {
            // Handle the case where vehicle is not present
            throw new IllegalArgumentException("Vehicle not found");
        }
    }


}



