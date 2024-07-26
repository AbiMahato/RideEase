package com.rideease.rideease.service;

import com.rideease.rideease.model.ProductBook;
import com.rideease.rideease.repository.ProductBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBookService {
    @Autowired
    private ProductBookRepository productBookRepository;

    public void saveProductBook(ProductBook productBook) {
        productBookRepository.save(productBook);
    }
}
