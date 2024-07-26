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
    public void sendEmail(String customerEmail, Optional<LendModel> vehicle) {

            String subject="RideEase";
            String message="Your have book vehicle from Ride Ease";

          String subject1="RideEase";
          String message1="Your vehicle have been booked by Ride Ease";

        if (vehicle.isPresent()) {
            LendModel abc = vehicle.get();

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



