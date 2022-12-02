package com.example.keabilabonnement.factories;

import com.example.keabilabonnement.contracts.factories.CustomerFactory;
import com.example.keabilabonnement.contracts.models.CustomerDetails;
import com.example.keabilabonnement.models.customers.Customer;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySQLCustomerFactory implements CustomerFactory {
    @Override
    public CustomerDetails buildFromResultSet(ResultSet set) {
        try {
            return buildFromSQLResult(set);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public CustomerDetails fillDetailsFromResultSet(CustomerDetails details,ResultSet set) {
        try {
            return fillFromSQLResult(details,set);
        }
        catch (SQLException e){
            e.printStackTrace();
            return details;
        }
    }

    private CustomerDetails fillFromSQLResult(CustomerDetails details,ResultSet set) throws SQLException {
        details.setLicenseID(set.getString("License_Id"));
        details.setCustomerName(set.getString("Name"));
        details.setCustomerAddress(set.getString("Address"));
        details.setCustomerPhone(set.getString("PhoneNumber"));
        return details;
    }

    private CustomerDetails buildFromSQLResult(ResultSet set) throws SQLException {
        CustomerDetails details = new Customer();
        details.setLicenseID(set.getString("License_Id"));
        details.setCustomerName(set.getString("Name"));
        details.setCustomerAddress(set.getString("Address"));
        details.setCustomerPhone(set.getString("PhoneNumber"));
        return details;
    }
}
