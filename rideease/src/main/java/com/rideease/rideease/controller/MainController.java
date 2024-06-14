package com.rideease.rideease.controller;


import com.rideease.rideease.model.ContactUsModel;
import com.rideease.rideease.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private ContactUsService contactUsService;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }


}
