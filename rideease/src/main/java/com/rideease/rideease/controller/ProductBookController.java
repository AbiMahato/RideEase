package com.rideease.rideease.controller;

import com.rideease.rideease.model.LendModel;
import com.rideease.rideease.model.ProductBook;
import com.rideease.rideease.repository.LendRepository;
import com.rideease.rideease.service.EmailService;
import com.rideease.rideease.service.LendService;
import com.rideease.rideease.service.ProductBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ProductBookController {
    @Autowired
    private ProductBookService productBookService;
    @Autowired
    private LendService lendService;

    @GetMapping("/user/product/{id}")
    public String showProductBookForm(@PathVariable("id") Long id, Model model) {
        Optional<LendModel> vehicle = lendService.getVehicleById(id);
        if (vehicle.isPresent()) {
            model.addAttribute("vehicle", vehicle.get());
            model.addAttribute("productBook", new ProductBook());
            model.addAttribute("page", "product");
            return "/user/product";
        } else {
            return "/"; // Return an error page if the card is not found
        }

    }
    @Autowired
    private EmailService emailService;
    @PostMapping("/user/product")
    public String submitProductBook(ProductBook productBook,Model model) {
        emailService.sendEmail();
        model.addAttribute("SuccessMessage", "Your email has been sent successfully.");

        productBookService.saveProductBook(productBook);
     return "/";
    }

}
