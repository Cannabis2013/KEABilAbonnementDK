package com.example.keabilabonnement.services.factories;

import com.example.keabilabonnement.contracts.factories.CarFactory;
import com.example.keabilabonnement.contracts.factories.CustomerFactory;
import com.example.keabilabonnement.contracts.models.CustomerDetails;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class RentalAgreementFactory {
    public RentalAgreementFactory(CarFactory carFactory, CustomerFactory customerFactory) {
        this.carFactory = carFactory;
        this.customerFactory = customerFactory;
    }

    public RentalAgreement empty() {
        return buildRentalWithID();
    }

    public RentalAgreement fromResultSet(ResultSet set) throws SQLException {
        RentalAgreement rentalAgreement = buildRentalFromSQLResult(set);
        carFactory.fillDetailsFromResultSet(rentalAgreement,set);
        customerFactory.fillDetailsFromResultSet(rentalAgreement,set);
        return rentalAgreement;
    }

    private RentalAgreement buildRentalFromSQLResult(ResultSet set) throws SQLException {
        RentalAgreement rentalAgreement = buildRentalWithID();
        rentalAgreement.setStart(set.getDate("StartDate").toLocalDate());
        rentalAgreement.setExpiration(set.getDate("ExpirationDate").toLocalDate());
        rentalAgreement.setDelevery(set.getDate("DeliveryDate").toLocalDate());
        rentalAgreement.setId(set.getString("Id"));
        rentalAgreement.setPayment(set.getDouble("RentalAgreement.Payment"));
        return rentalAgreement;
    }

    private RentalAgreement buildRentalWithID(){
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setId(UUID.randomUUID().toString());
        rentalAgreement.setStart(LocalDate.now());
        rentalAgreement.setExpiration(LocalDate.now());
        return rentalAgreement;
    }

    private final CarFactory carFactory;
    private final CustomerFactory customerFactory;
}
