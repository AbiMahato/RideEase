package com.rideease.rideease.service;

import com.rideease.rideease.repository.ContactUsRepository;
import com.rideease.rideease.model.ContactUsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsServiceImpl implements ContactUsService{
    @Autowired
    private ContactUsRepository contactUsRepository;

    @Override
    public void saveContact(ContactUsModel contact) {
        contactUsRepository.save(contact);
    }

    @Override
    public List<ContactUsModel> getCustomerFeedbacks(){
        return contactUsRepository.findAll();
    }
}

