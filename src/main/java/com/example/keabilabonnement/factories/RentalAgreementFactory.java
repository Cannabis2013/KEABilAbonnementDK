package com.example.keabilabonnement.factories;

import com.example.keabilabonnement.contracts.agreement.Agreement;
import com.example.keabilabonnement.contracts.agreement.AgreementFactory;
import com.example.keabilabonnement.contracts.auxiliary.CarFactory;
import com.example.keabilabonnement.contracts.auxiliary.CustomerFactory;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RentalAgreementFactory implements AgreementFactory {

    /*

        Author: Martin Hansen

    */

    private final CarFactory carFactory;
    private final CustomerFactory customerFactory;

    public RentalAgreementFactory(CarFactory carFactory, CustomerFactory customerFactory) {
        this.carFactory = carFactory;
        this.customerFactory = customerFactory;
    }

    private RentalAgreement buildRentalWithId() {
        var rentalAgreement = new RentalAgreement();
        var start = LocalDate.now();
        var expiration = LocalDate.now().plusMonths(1);
        rentalAgreement.setId(UUID.randomUUID().toString());
        rentalAgreement.setStart(start);
        rentalAgreement.setExpiration(expiration);
        rentalAgreement.setDelevery(expiration);
        return rentalAgreement;
    }

    private RentalAgreement buildRentalFromSQLResult(ResultSet set) throws SQLException {
        RentalAgreement rentalAgreement = buildRentalWithId();
        rentalAgreement.setStart(set.getDate("StartDate").toLocalDate());
        rentalAgreement.setExpiration(set.getDate("ExpirationDate").toLocalDate());
        rentalAgreement.setDelevery(set.getDate("DeliveryDate").toLocalDate());
        rentalAgreement.setId(set.getString("Id"));
        rentalAgreement.setPayment(set.getDouble("RentalAgreement.Payment"));
        return rentalAgreement;
    }

    public RentalAgreement agreementFromResultSet(ResultSet set) throws SQLException {
        if (!set.next())
            return null;
        return fromResultSet(set);
    }

    public RentalAgreement fromResultSet(ResultSet set) throws SQLException {
        RentalAgreement rentalAgreement = buildRentalFromSQLResult(set);
        carFactory.fillDetailsFromResultSet(rentalAgreement, set);
        customerFactory.fillDetailsFromResultSet(rentalAgreement, set);
        return rentalAgreement;
    }


    @Override
    public RentalAgreement empty() {
        return buildRentalWithId();
    }

    @Override
    public List<Agreement> agreementsFromResultSet(ResultSet set) throws SQLException {
        List<Agreement> agreements = new ArrayList<>();
        while (set.next())
            agreements.add(fromResultSet(set));
        return agreements;
    }

}
