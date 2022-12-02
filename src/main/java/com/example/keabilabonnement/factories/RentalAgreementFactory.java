package com.example.keabilabonnement.factories;

import com.example.keabilabonnement.contracts.agreement.AgreementFactory;
import com.example.keabilabonnement.contracts.auxiliary.CarFactory;
import com.example.keabilabonnement.contracts.auxiliary.CustomerFactory;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class RentalAgreementFactory implements AgreementFactory {
    public RentalAgreementFactory(CarFactory carFactory, CustomerFactory customerFactory) {
        this.carFactory = carFactory;
        this.customerFactory = customerFactory;
    }

    @Override
    public RentalAgreement empty() {
        return buildRentalWithID();
    }

    @Override
    public RentalAgreement fromResultSet(ResultSet set) throws SQLException {
        RentalAgreement rentalAgreement = buildRentalFromSQLResult(set);
        carFactory.fillDetailsFromResultSet(rentalAgreement,set);
        customerFactory.fillDetailsFromResultSet(rentalAgreement,set);
        return rentalAgreement;
    }

    private final CarFactory carFactory;
    private final CustomerFactory customerFactory;
}
