package com.example.keabilabonnement.services.factories;

import com.example.keabilabonnement.contracts.factories.CustomerFactory;
import com.example.keabilabonnement.models.customers.Customer;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySQLCustomerFactory implements CustomerFactory {
    @Override
    public Customer fromResultSet(ResultSet set) {
        try {
            return buildFromSQLResult(set);
        }
        catch (SQLException e){
            return null;
        }
    }

    private Customer buildFromSQLResult(ResultSet set) throws SQLException {
        Customer customer = new Customer();
        customer.setLicenseID(set.getString("License_Id"));
        customer.setName(set.getString("Name"));
        customer.setAddress(set.getString("Address"));
        customer.setPhoneNumber(set.getString("PhoneNumber"));
        return customer;
    }
}
