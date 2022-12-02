package com.example.keabilabonnement.contracts.agreement;

import com.example.keabilabonnement.models.registration.RentalAgreement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

public interface AgreementFactory {
    RentalAgreement empty();

    RentalAgreement fromResultSet(ResultSet set) throws SQLException;

    default RentalAgreement buildRentalFromSQLResult(ResultSet set) throws SQLException {
        RentalAgreement rentalAgreement = buildRentalWithID();
        rentalAgreement.setStart(set.getDate("StartDate").toLocalDate());
        rentalAgreement.setExpiration(set.getDate("ExpirationDate").toLocalDate());
        rentalAgreement.setDelevery(set.getDate("DeliveryDate").toLocalDate());
        rentalAgreement.setId(set.getString("Id"));
        rentalAgreement.setPayment(set.getDouble("RentalAgreement.Payment"));
        return rentalAgreement;
    }

    default RentalAgreement buildRentalWithID() {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setId(UUID.randomUUID().toString());
        rentalAgreement.setStart(LocalDate.now());
        rentalAgreement.setExpiration(LocalDate.now());
        return rentalAgreement;
    }
}
