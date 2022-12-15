package com.example.keabilabonnement.Repository.rental;

import com.example.keabilabonnement.models.registration.RentalAgreement;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.UUID;

// Author: Martin Hansen
@Service
class RentalFactoryTest {
    public RentalAgreement rentalOne(){
        var rental = agreement();
        rental.setInternalNumber("TS116");
        rental.setLicenseID("12345678");
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

    private String randomID(){
        return UUID.randomUUID().toString();
    }
}
