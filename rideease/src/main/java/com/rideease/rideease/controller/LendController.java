package com.rideease.rideease.controller;

import com.rideease.rideease.model.ContactUsModel;
import com.rideease.rideease.model.LendModel;
import com.rideease.rideease.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LendController {
    @Autowired
    private LendService lendService;

    @GetMapping("/lend")
    public String showLendForm(Model model) {
        model.addAttribute("lend", new LendModel());
        return "lend";
    }
    @PostMapping("/lend")
    public String submitLendForm(LendModel lend) {
        lendService.saveLendDetails(lend);
        return "redirect:/lend";
    }
}
