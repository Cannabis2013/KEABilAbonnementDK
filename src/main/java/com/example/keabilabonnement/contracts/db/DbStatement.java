package com.example.keabilabonnement.contracts.db;

import java.sql.PreparedStatement;

public interface DbStatement {
    PreparedStatement get(String sql);
}
