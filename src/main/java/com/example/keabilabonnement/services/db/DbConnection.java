package com.example.keabilabonnement.services.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class is implemented as a singleton to ensure that only
// one database connection is active at a time.
public class DbConnection {
    private static DbConnection instance;
    private final Connection connection;

    private DbConnection(String url, String username, String password) {
        connection = establishDBConnection(url,username,password);
    }

    public static DbConnection getInstance(String url, String username, String password) {
        if (instance == null)
            instance = new DbConnection(url,username,password);
        return instance;
    }

    public Connection get() {
        return connection;
    }

    private Connection establishDBConnection(String url, String username, String password) {
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println("Failed to establish a database connection");
        }
        return null;
    }
}