package com.example.keabilabonnement.Repository.Registration;

import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.customers.Customer;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;
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
        reg.setId(randomID());
        return reg;
    }

    private Car randomCar(){
        var car = new Car();
        car.setCarNumber(randomNumberAsString());
        car.setId(randomID());
        return car;
    }

    private Customer randomCustomer(){
        var customer = new Customer();
        customer.setId(randomID());
        customer.setLicenseID(randomNumberAsString());
        return customer;
    }

    private String randomID(){
        return UUID.randomUUID().toString();
    }

    private String randomNumberAsString(){
        var rand = new Random();
        var randVal = rand.nextInt(100000);
        return String.valueOf(randVal);
    }
}
