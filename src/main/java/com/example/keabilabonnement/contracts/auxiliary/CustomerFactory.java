package com.example.keabilabonnement.contracts.auxiliary;

import java.sql.ResultSet;

public interface CustomerFactory {
    CustomerDetails buildFromResultSet(ResultSet set);
    CustomerDetails fillDetailsFromResultSet(CustomerDetails details,ResultSet set);
}
