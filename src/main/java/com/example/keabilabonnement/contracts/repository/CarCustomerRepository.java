package com.example.keabilabonnement.contracts.repository;

import com.example.keabilabonnement.contracts.models.CarDetails;
import com.example.keabilabonnement.contracts.models.CustomerDetails;

import java.util.List;

public interface CarCustomerRepository {
    List<CarDetails> getCars();
    List<CustomerDetails> getCustomers();
}
