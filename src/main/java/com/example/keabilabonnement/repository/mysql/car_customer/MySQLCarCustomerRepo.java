package com.example.keabilabonnement.repository.mysql.car_customer;

import com.example.keabilabonnement.contracts.repository.CarCustomerRepository;
import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.customers.Customer;
import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class MySQLCarCustomerRepo implements CarCustomerRepository {

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
                String Brand = RS.getString("Brand");
                String Model = RS.getString("Model");
                String VIN = RS.getString("VIN");
                String Number = RS.getString("Number");
                int year = RS.getInt("Year");

                Car car = new Car();
                car.setBrand(Brand);
                car.setModel(Model);
                car.setYear(year);
                car.setVin(VIN);
                car.setCarNumber(Number);

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
                String License_Id = RS.getString("License_Id");
                String Name = RS.getString("Name");
                Date Birthday = RS.getDate("Birthday");
                String Address = RS.getString("Address");
                String PhoneNumber = RS.getString("PhoneNumber");

                Customer customer = new Customer();
                customer.setLicenseID(License_Id);
                customer.setName(Name);
                customer.setBirthday(Birthday.toLocalDate());
                customer.setAddress(Address);
                customer.setPhoneNumber(PhoneNumber);

                listOfCustomer.add(customer);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listOfCustomer;
    }
}
