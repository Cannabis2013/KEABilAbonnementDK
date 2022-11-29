package com.example.keabilabonnement.models.Db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/*
    A PreparedStatement wrapper

    This wrapper introduces a more builder pattern oriented approach
 */

public class MySQLStatement {
    public MySQLStatement(PreparedStatement prepared){
        statement = prepared;
    }

    public boolean execute() throws SQLException {
        return statement.execute();
    }

    public ResultSet executeQuery() throws SQLException {
        return statement.executeQuery();
    }

    public MySQLStatement setString(int index, String value) throws SQLException {
        statement.setString(index,value);
        return this;
    }

    public MySQLStatement setInt(int index, int value) throws SQLException {
        statement.setInt(index,value);
        return this;
    }

    public MySQLStatement setDate(int index, LocalDate value) throws SQLException {
        var date = Date.valueOf(value);
        statement.setDate(index,date);
        return this;
    }

    private final PreparedStatement statement;
}
