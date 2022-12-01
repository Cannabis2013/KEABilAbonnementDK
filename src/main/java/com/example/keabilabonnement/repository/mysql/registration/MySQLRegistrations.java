package com.example.keabilabonnement.repository.mysql.registration;

import com.example.keabilabonnement.contracts.models.Agreement;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import com.example.keabilabonnement.services.db.DBConnection;
import com.example.keabilabonnement.services.factories.RentalAgreementFactory;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MySQLRegistrations {
    public MySQLRegistrations(RentalAgreementFactory rentalAgreementFactory) {
        this.rentalAgreementFactory = rentalAgreementFactory;
    }

    public Agreement  getRegistration(String id){
        String sql = """
                SELECT *
                FROM RentalAgreement
                INNER JOIN Car
                ON RentalAgreement.CarNumber = Car.Number
                INNER JOIN Customer
                ON RentalAgreement.CustomerLicense_Id = Customer.License_Id
                WHERE Id=?;
                """;
        try {
            // RentalAgreement - Car - Customer
            PreparedStatement statement = DBConnection.statement(sql);
            statement.setString(1, id);
            ResultSet set = statement.executeQuery();
            return rentalAgreementFactory.fromResultSet(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public List<Agreement> getAllRegistrations(){
        List<Agreement > rentalAgreements = new ArrayList<>();
        String sql = """
                SELECT *
                FROM RentalAgreement
                INNER JOIN Car
                ON RentalAgreement.CarNumber = Car.Number
                INNER JOIN Customer
                ON RentalAgreement.CustomerLicense_Id = Customer.License_Id;
                """;
        try {
            PreparedStatement query = DBConnection.statement(sql);
            ResultSet set = query.executeQuery();
            while (set.next()) {
                rentalAgreements.add(rentalAgreementFactory.fromResultSet(set));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalAgreements;
    }
    public List<Agreement > getAllActiveRegistrations(){
        List<Agreement > rentalAgreements = new ArrayList<>();
        String sql = """
                SELECT *
                FROM RentalAgreement
                INNER JOIN Car
                ON RentalAgreement.CarNumber = Car.Number
                INNER JOIN Customer
                ON RentalAgreement.CustomerLicense_Id = Customer.License_Id
                WHERE NOW() < ExpirationDate;
                """;
        try {
            PreparedStatement query = DBConnection.statement(sql);
            ResultSet set = query.executeQuery();
            while (set.next()) {
                rentalAgreements.add(rentalAgreementFactory.fromResultSet(set));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalAgreements;
    }

    private final RentalAgreementFactory rentalAgreementFactory;
}
