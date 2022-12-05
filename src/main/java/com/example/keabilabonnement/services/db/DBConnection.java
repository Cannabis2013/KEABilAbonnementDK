package com.example.keabilabonnement.services.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// A singleton class for DB connection. There is only one instance for the entirety of the program.
// There can be only one! (Highlander=)
public class DBConnection {

    private static DBConnection instance;
    private final Connection connection;

    //Constructor without parameters
    private DBConnection() {
        connection = establishDBConnection();
    }

    //Method that returns Database Connection
    private Connection establishDBConnection() {
        //Environmental Variables
        String db_url = System.getenv("ConStr");
        String username = System.getenv("DbUser");
        String password = System.getenv("DbPass");
        try {//Make Connection with SQLException.
            return DriverManager.getConnection(db_url,username,password);
        } catch (SQLException e) {
            System.out.println("Failed to establish a database connection");
            e.printStackTrace();
        }
        return null;
    }

    //If there isn't already an instance of connection, then we make one.
    private static DBConnection getInstance() {
        if (instance == null)
            instance = new DBConnection();
        return instance;
    }

    public static PreparedStatement statement(String sql) throws SQLException {
        //Initializing connection
        DBConnection instance = DBConnection.getInstance();
        //Create and Get connection (we can call connection variable in same class)
        Connection conn = instance.connection;
        //If conn is not established as connection, it throws SQLException
        if (conn == null)
            throw new SQLException();
        return conn.prepareStatement(sql);
    }

}
