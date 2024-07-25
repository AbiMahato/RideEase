package com.rideease.rideease.controller;

import com.rideease.rideease.model.ContactUsModel;
import com.rideease.rideease.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactUsController {
    @Autowired
    private ContactUsService contactUsService;

    @GetMapping("/contactus")
    public String showContactForm(Model model) {

        model.addAttribute("contactus", new ContactUsModel());
        model.addAttribute("page", "contactus");
        return "contactus";
    }

    @PostMapping("/contactus")
    public String submitContactForm(ContactUsModel contact) {
        contactUsService.saveContact(contact);
        return "redirect:/contactus";
    }
}
