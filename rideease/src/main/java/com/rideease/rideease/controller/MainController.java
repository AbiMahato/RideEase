package com.rideease.rideease.controller;


import com.rideease.rideease.model.ContactUsModel;
import com.rideease.rideease.model.LendModel;
import com.rideease.rideease.service.ContactUsService;
import com.rideease.rideease.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private LendService lendService;

    @GetMapping("/")
    public String home(@RequestParam(value = "currentLocation", required = false) String currentLocation,
                       @RequestParam(value = "vehicleType", required = false) String vehicleType,
                       Model model) {

        List<LendModel> lendDetail;
        if (currentLocation == null || vehicleType == null) {
            lendDetail = lendService.getLendDetails();
        } else {
            lendDetail = lendService.searchVehicles(currentLocation, vehicleType);
        }

        model.addAttribute("lendDetail", lendDetail);
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



//    @GetMapping("/user/product")
//    public String product(Model model , Principal principal) {
//        System.out.println(principal.getName());
//        model.addAttribute("page", "product");
//        return "user/product";
//    }

    @GetMapping("/vehicle_list")
    public String vehicleList(Model model) {
        List<LendModel> lendDetail =lendService.getLendDetails();
        model.addAttribute("lendDetail", lendDetail);
        model.addAttribute("page", "vehiclelist");
        return "vehicle_list";
    }


    @Autowired
    private ContactUsService contactUsService;

    @GetMapping("/admin/admin_contact_us")
    public String admin_contact_us(Model model) {
        List<ContactUsModel> customerFeedbacks =contactUsService.getCustomerFeedbacks();
        model.addAttribute("customerFeedbacks", customerFeedbacks);
        model.addAttribute("page", "admin_contact_us");
        return "admin/admin_contactus";
    }


    @GetMapping("/admin/admin_dashboard")
    public String admin_dashboard(Model model) {
        model.addAttribute("page", "admin_dashboard");
        return "admin/admin_dashboard";
    }


    @GetMapping("/admin/admin_all_vehicles")
    public String admin_all_vehicles(Model model) {
        List<LendModel> lendDetail =lendService.getLendDetails();
        model.addAttribute("lendDetail", lendDetail);
        model.addAttribute("page", "admin_all_vehicles");
        return "admin/admin_all_vehicles";
    }

    @PostMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        lendService.deleteVehicleById(id);
        return "redirect:/admin/admin_all_vehicles"; // Redirect to the list of vehicles or another appropriate page
    }


}
