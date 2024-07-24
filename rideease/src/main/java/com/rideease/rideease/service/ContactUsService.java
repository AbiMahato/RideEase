package com.rideease.rideease.service;

import com.rideease.rideease.model.ContactUsModel;

import java.util.List;

public interface ContactUsService {
    void saveContact(ContactUsModel contact);
    List<ContactUsModel> getCustomerFeedbacks();
}
