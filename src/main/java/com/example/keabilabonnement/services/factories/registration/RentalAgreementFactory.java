package com.example.keabilabonnement.services.factories.registration;

import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.customers.Customer;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class RentalAgreementFactory {
    public RentalAgreement fromResultSet(ResultSet set) throws SQLException {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setStart(set.getDate("StartDate").toLocalDate());
        rentalAgreement.setExpiration(set.getDate("ExpirationDate").toLocalDate());
        rentalAgreement.setDelevery(set.getDate("DeliveryDate").toLocalDate());
        rentalAgreement.setId(set.getString("Id"));

        Car car = new Car();
        car.setCarNumber(set.getString("Number"));
        car.setVin(set.getString("VIN"));
        car.setModel(set.getString("Model"));
        car.setBrand(set.getString("Brand"));

        Customer customer = new Customer();
        customer.setLicenseID(set.getString("License_Id"));
        customer.setName(set.getString("Name"));
        customer.setBirthday(set.getDate("Birthday").toLocalDate());
        customer.setAddress(set.getString("Address"));
        customer.setPhoneNumber(set.getString("PhoneNumber"));

        rentalAgreement.setCar(car);
        rentalAgreement.setCustomer(customer);
        return rentalAgreement;
    }
}
