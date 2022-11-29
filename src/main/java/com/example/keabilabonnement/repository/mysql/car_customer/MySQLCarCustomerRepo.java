package com.example.keabilabonnement.repository.mysql.car_customer;

import com.example.keabilabonnement.contracts.repository.CarCustomerRepository;
import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.customers.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySQLCarCustomerRepo implements CarCustomerRepository {

    @Override
    public List<Car> getCar() {
        return null;
    }

    @Override
    public List<Customer> getCustomers() {
        return null;
    }

}
