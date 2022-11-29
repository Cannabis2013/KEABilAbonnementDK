package com.example.keabilabonnement.contracts.repository;

import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.customers.Customer;

import java.util.List;

public interface CarCustomerRepository {
    List<Car> getCar();
    List<Customer> getCustomers();
}
