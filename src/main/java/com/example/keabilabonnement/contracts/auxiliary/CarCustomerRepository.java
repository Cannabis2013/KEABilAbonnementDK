package com.example.keabilabonnement.contracts.auxiliary;

import com.example.keabilabonnement.contracts.auxiliary.CarDetails;
import com.example.keabilabonnement.contracts.auxiliary.CustomerDetails;

import java.util.List;

public interface CarCustomerRepository {

    /*

        Authors: Nikki Deleuran - M. Kaan Arici - Stefan Jensen - Martin Hansen

    */

    List<CarDetails> getCars();
    List<CustomerDetails> getCustomers();
}
