package com.example.keabilabonnement.repository.mysql.car_customer;

import com.example.keabilabonnement.contracts.factories.CarFactory;
import com.example.keabilabonnement.contracts.factories.CustomerFactory;
import com.example.keabilabonnement.contracts.repository.CarCustomerRepository;
import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.customers.Customer;
import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class MySQLCarCustomerRepo implements CarCustomerRepository {

    public MySQLCarCustomerRepo(CarFactory carFactory, CustomerFactory customerFactory) {
        this.carFactory = carFactory;
        this.customerFactory = customerFactory;
    }

    @Override
    public List<Car> getCars() {

        List<Car> listOfCar = new LinkedList<>();

        String sql = """
                SELECT * FROM Car;
                """;

        try {
            PreparedStatement statement = DBConnection.statement(sql);
            ResultSet RS = statement.executeQuery();

            while (RS.next()) {
                Car car = carFactory.fromResultSet(RS);
                listOfCar.add(car);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listOfCar;
    }

    @Override
    public List<Customer> getCustomers() {

        List<Customer> listOfCustomer = new LinkedList<>();

        String sql = """
                SELECT * FROM Customer;
                """;

        try {
            PreparedStatement statement = DBConnection.statement(sql);
            ResultSet RS = statement.executeQuery();

            while (RS.next()) {
                Customer customer = customerFactory.fromResultSet(RS);
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
