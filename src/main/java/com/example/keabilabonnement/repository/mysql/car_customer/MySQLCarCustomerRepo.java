package com.example.keabilabonnement.repository.mysql.car_customer;

import com.example.keabilabonnement.contracts.auxiliary.CarFactory;
import com.example.keabilabonnement.contracts.auxiliary.CustomerFactory;
import com.example.keabilabonnement.contracts.auxiliary.CarDetails;
import com.example.keabilabonnement.contracts.auxiliary.CustomerDetails;
import com.example.keabilabonnement.contracts.auxiliary.CarCustomerRepository;
import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class MySQLCarCustomerRepo implements CarCustomerRepository {

    /*

        Author: Nikki Deleuran

    */

    public MySQLCarCustomerRepo(CarFactory carFactory, CustomerFactory customerFactory) {
        this.carFactory = carFactory;
        this.customerFactory = customerFactory;
    }

    @Override
    public List<CarDetails> getCars() {

        List<CarDetails> listOfCar = new LinkedList<>();

        String sql = """
                SELECT * FROM AvailableCars;
                """;

        try {
            PreparedStatement statement = DBConnection.statement(sql);
            ResultSet RS = statement.executeQuery();

            while (RS.next()) {
                CarDetails car = carFactory.buildFromResultSet(RS);
                listOfCar.add(car);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listOfCar;
    }

    @Override
    public List<CustomerDetails> getCustomers() {

        List<CustomerDetails> listOfCustomer = new LinkedList<>();

        String sql = """
                SELECT * FROM Customer;
                """;

        try {
            PreparedStatement statement = DBConnection.statement(sql);
            ResultSet RS = statement.executeQuery();

            while (RS.next()) {
                CustomerDetails customer = customerFactory.buildFromResultSet(RS);
                listOfCustomer.add(customer);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listOfCustomer;
    }

    private final CarFactory carFactory;
    private final CustomerFactory customerFactory;
}
