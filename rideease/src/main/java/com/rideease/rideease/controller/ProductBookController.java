package com.rideease.rideease.controller;

import com.rideease.rideease.model.ProductBook;
import com.rideease.rideease.service.EmailService;
import com.rideease.rideease.service.ProductBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductBookController {
    @Autowired
    private ProductBookService productBookService;

    @GetMapping("/product")
    public String showProductBookForm(Model model) {
        model.addAttribute("productBook", new ProductBook());
        return "product";
    }
    @Autowired
    private EmailService emailService;
    @PostMapping("/product")
    public String submitProductBook(ProductBook productBook,Model model) {
        emailService.sendEmail();
        model.addAttribute("SuccessMessage", "Your email has been sent successfully.");

        productBookService.saveProductBook(productBook);
     return "user/product";
    }

}
