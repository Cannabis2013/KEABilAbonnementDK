package com.example.keabilabonnement.services.factories;

import com.example.keabilabonnement.contracts.factories.CarFactory;
import com.example.keabilabonnement.contracts.factories.CustomerFactory;
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
    public RentalAgreementFactory(CarFactory carFactory, CustomerFactory customerFactory) {
        this.carFactory = carFactory;
        this.customerFactory = customerFactory;
    }

    public RentalAgreement empty() {
        return buildRentalWithID();
    }

    public RentalAgreement fromResultSet(ResultSet set) throws SQLException {
        RentalAgreement rentalAgreement = buildRentalFromSQLResult(set);
        Car car = carFactory.fromResultSet(set);
        if(car != null)
            rentalAgreement.setCar(car);
        Customer customer = customerFactory.fromResultSet(set);
        if(customer != null)
            rentalAgreement.setCustomer(customer);
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
