package com.rideease.rideease.controller;


import com.rideease.rideease.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    //SHOW THE EMAIL FROM
    @GetMapping("/send-email")
    public String showEmailForm() {
        return "/user/send-email";
    }

    @PostMapping("/send-email")
    public String sendEmail(Model model) {
        emailService.sendEmail();
        model.addAttribute("SuccessMessage", "Your email has been sent successfully."
        );
        return "/user/send-email";
    }

}
