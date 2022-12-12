package com.example.keabilabonnement.repository.mysql.agreement;

import com.example.keabilabonnement.contracts.agreement.AgreementFactory;
import com.example.keabilabonnement.contracts.agreement.Agreement;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MySQLAgreements {
    public MySQLAgreements(AgreementFactory rentalAgreementFactory) {
        this.rentalAgreementFactory = rentalAgreementFactory;
    }

    public Agreement getAgreement(String id){
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
            PreparedStatement statement = DBConnection.statement(sql);
            statement.setString(1, id);
            ResultSet set = statement.executeQuery();
            return rentalAgreementFactory.agreementFromResultSet(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<Agreement> getAllAgreements(){
        String sql = """
                SELECT *
                FROM RentalAgreement
                INNER JOIN Car
                ON RentalAgreement.CarNumber = Car.Number
                INNER JOIN Customer
                ON RentalAgreement.CustomerLicense_Id = Customer.License_Id;
                """;
        return agreementsFromDatabase(sql);
    }

    public List<Agreement > getAllActiveAgreements(){
        String sql = """
                SELECT *
                FROM RentalAgreement
                INNER JOIN Car
                ON RentalAgreement.CarNumber = Car.Number
                INNER JOIN Customer
                ON RentalAgreement.CustomerLicense_Id = Customer.License_Id
                WHERE STARTDATE < NOW() AND NOW() < ExpirationDate;
                """;
        return agreementsFromDatabase(sql);
    }

    private List<Agreement> agreementsFromDatabase(String sql) {
        try {
            PreparedStatement query = DBConnection.statement(sql);
            ResultSet set = query.executeQuery();
            return rentalAgreementFactory.agreementsFromResultSet(set);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private final AgreementFactory rentalAgreementFactory;
}
