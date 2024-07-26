package com.rideease.rideease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailsender;

    public static final String TO="nisan11prajapati@gmail.com";
    public static final String SUBJECT="RideEase";
    public static final String MESSAGE="Your vehicle have been booked Your vehicle have been booked by email with phone number .Contact the Customer for more information";


    //Method to send email
    public void sendEmail(){


        SimpleMailMessage email=new SimpleMailMessage();
        email.setTo(TO);
        email.setSubject(SUBJECT);
        email.setText(MESSAGE);
        mailsender.send(email);
    }


}



