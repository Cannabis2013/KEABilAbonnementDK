package com.example.keabilabonnement.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// A singleton class for DB connection, meaning there is only one instance for the entirety of the program.
// There can be only one! (Highlander=)
public class DBConnection {

    private static DBConnection instance;
    private final Connection connection;

    //constructer without parameters
    private DBConnection() {
        connection = establishDBConnection();
    }

    //method that returns Database Connection
    private Connection establishDBConnection() {
        //Environmental Variables
        String db_url = System.getenv("ConStr");
        String username = System.getenv("DbUser");
        String password = System.getenv("DbPass");
        try {//try to make DB Connection with Exception
            return DriverManager.getConnection(db_url,username,password);
        } catch (SQLException e) {
            System.out.println("Failed to establish a database connection");
            e.printStackTrace();
        }
        return null;
    }

    // if there isn't already a connection (an instance of connection), then we make one.
    private static DBConnection getInstance() {
        if (instance == null)
            instance = new DBConnection();
        return instance;
    }

    public static PreparedStatement statement(String sql) throws SQLException {
        //initializing connection
        DBConnection instance = DBConnection.getInstance();
        //get connection
        Connection conn = instance.connection;
        //if conn is not established, throws exception
        if (conn == null)
            throw new SQLException();
        return conn.prepareStatement(sql);
    }

}
