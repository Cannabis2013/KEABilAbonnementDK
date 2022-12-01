package com.example.keabilabonnement.services.factories;

import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.customers.Customer;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class RentalAgreementFactory {
    public RentalAgreement empty() {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setId(UUID.randomUUID().toString());
        rentalAgreement.setStart(LocalDate.now());
        rentalAgreement.setExpiration(LocalDate.now());
        return rentalAgreement;
    }
    public RentalAgreement fromResultSet(ResultSet set) throws SQLException {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setStart(set.getDate("StartDate").toLocalDate());
        rentalAgreement.setExpiration(set.getDate("ExpirationDate").toLocalDate());
        rentalAgreement.setDelevery(set.getDate("DeliveryDate").toLocalDate());
        rentalAgreement.setId(set.getString("Id"));
        rentalAgreement.setPayment(set.getDouble("RentalAgreement.Payment"));

        return rentalAgreement;
    }
}
