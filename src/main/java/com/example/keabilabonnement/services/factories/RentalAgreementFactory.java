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
        Car car = new Car();
        Customer customer = new Customer();
        rentalAgreement.setStart(set.getDate("StartDate").toLocalDate());
        rentalAgreement.setExpiration(set.getDate("ExpirationDate").toLocalDate());
        rentalAgreement.setDelevery(set.getDate("DeliveryDate").toLocalDate());
        rentalAgreement.setId(set.getString("Id"));
        rentalAgreement.setPayment(set.getDouble("RentalAgreement.Payment"));

        /*
            We should implement a car factory class we can use across contexts.
         */
        car.setCarNumber(set.getString("Number"));
        car.setVin(set.getString("VIN"));
        car.setModel(set.getString("Model"));
        car.setBrand(set.getString("Brand"));
        car.setYear(set.getInt("Year"));

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
