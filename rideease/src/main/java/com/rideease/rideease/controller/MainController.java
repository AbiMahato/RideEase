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
        model.addAttribute("page", "index");
        return "index";
    }

    @GetMapping("/aboutus")
    public String aboutus(Model model) {
        model.addAttribute("page", "aboutus");
        return "aboutus";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("page", "product");
        return "product";
    }
    @GetMapping("/vehicle_list")
    public String vehicleList(Model model) {
        model.addAttribute("page", "vehiclelist");
        return "vehicle_list";
    }


}
