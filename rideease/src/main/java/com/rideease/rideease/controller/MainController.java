package com.rideease.rideease.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

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



    @GetMapping("/user/product")
    public String product(Model model) {
        model.addAttribute("page", "product");
        return "user/product";
    }

    @GetMapping("/vehicle_list")
    public String vehicleList(Model model) {
        model.addAttribute("page", "vehiclelist");
        return "vehicle_list";
    }


}
