package com.example.keabilabonnement.services.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// A singleton class for DB connection.
// (There can be only one! - Highlander=)
public class DBConnection {
    //A static variable of the DBConnection class is created.
    private static DBConnection instance;
    //A final variable of Connection class is created.
    private final Connection connection;

    //Constructor (with no parameter) that calls for establishDBConnection method.
    private DBConnection() {
        connection = establishDBConnection();
    }

    //First, we check if there is already an instance of connection.
    private static DBConnection getInstance() {
        if (instance == null)
            //If not then we make one by calling back to DBConnection constructor.
            instance = new DBConnection();
        return instance;
    }

    //Method that makes Database Connection
    private Connection establishDBConnection() {
        //Environmental Variables
        String db_url = System.getenv("ConStr");
        String username = System.getenv("DbUser");
        String password = System.getenv("DbPass");
        try {//Environmental Variables are used to get connection by DriverManager class.
            return DriverManager.getConnection(db_url,username,password);
        } catch (SQLException e) { //SQL Exception if connection fails.
            System.out.println("Failed to establish a database connection");
            e.printStackTrace();
        }
        return null;
    }


    public static PreparedStatement statement(String sql) throws SQLException {
        //Check for existing connection by creating a variable, which returns getInstance.
        DBConnection instance = DBConnection.getInstance();
        //Create a variable that calls connection variable, which in return calls establishDBConnection.
        Connection conn = instance.connection;
        //If conn is not established as connection, it throws SQLException
        if (conn == null)
            throw new SQLException();
        return conn.prepareStatement(sql);
    }
}
