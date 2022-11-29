package com.example.keabilabonnement.models.registration;

import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.customers.Customer;
import com.example.keabilabonnement.models.entity.Entity;
import java.time.LocalDate;

public class RentalAgreement extends Entity {
    private LocalDate start;
    private LocalDate expiration;
    private LocalDate delevery;
    private Customer customer;
    private double payment;

    private Car car;

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public LocalDate getDelevery() {
        return delevery;
    }

    public void setDelevery(LocalDate delevery) {
        this.delevery = delevery;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
