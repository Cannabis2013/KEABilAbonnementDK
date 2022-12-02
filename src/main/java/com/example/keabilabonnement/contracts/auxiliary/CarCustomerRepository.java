package com.example.keabilabonnement.contracts.auxiliary;

import com.example.keabilabonnement.contracts.auxiliary.CarDetails;
import com.example.keabilabonnement.contracts.auxiliary.CustomerDetails;

import java.util.List;

public interface CarCustomerRepository {
    List<CarDetails> getCars();
    List<CustomerDetails> getCustomers();
}
