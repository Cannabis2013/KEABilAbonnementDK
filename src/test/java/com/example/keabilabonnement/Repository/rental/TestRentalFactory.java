package com.example.keabilabonnement.Repository.rental;

import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.customers.Customer;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.UUID;

@Service
class TestRentalFactory {
    public RentalAgreement rentalOne(){
        var rental = agreement();
        rental.setCar(randomCar());
        rental.setCustomer(randomCustomer());
        var dateToday = LocalDate.now();
        rental.setStart(dateToday);
        var expirationDate = dateToday.plusMonths(2);
        rental.setExpiration(expirationDate);
        rental.setDelevery(expirationDate);
        return rental;
    }

    private RentalAgreement agreement(){
        var reg = new RentalAgreement();
        reg.setId("42a90b5e-bc1a-4380-aa34-d47c21fc617b");
        return reg;
    }

    private Car randomCar(){
        var car = new Car();
        car.setCarNumber("TS116");
        car.setId(randomID());
        return car;
    }

    private Customer randomCustomer(){
        var customer = new Customer();
        customer.setId(randomID());
        customer.setLicenseID("12345678");
        return customer;
    }

    private String randomID(){
        return UUID.randomUUID().toString();
    }
}