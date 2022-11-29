package com.example.keabilabonnement.services.db;

import com.example.keabilabonnement.contracts.db.DbStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Class is implemented as a singleton to ensure that only
// one database connection is active at a time.
public class DbPreparedStatement {

    public static PreparedStatement get(String sql) throws SQLException {
        var instance = DbPreparedStatement.getInstance();
        var con = instance.connection;
        if(con == null)
            throw new SQLException();
        return con.prepareStatement(sql);
    }

    private static DbPreparedStatement instance;
    private final Connection connection;

    private DbPreparedStatement() {
        connection = establishDBConnection();
    }

    private static DbPreparedStatement getInstance() {
        if (instance == null)
            instance = new DbPreparedStatement();
        return instance;
    }

    private Connection establishDBConnection() {
        var url = System.getenv("ConStr");
        var username = System.getenv("DbUser");
        var password = System.getenv("DbPass");
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println("Failed to establish a database connection");
        }
        return null;
    }
}