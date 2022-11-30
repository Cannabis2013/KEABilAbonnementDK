package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.models.inspection.Damage;
import com.example.keabilabonnement.models.inspection.Report;

import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

@Service
public class MySQLInspectionAdder {

    public Boolean add(Report newDamageReport) {
        newDamageReport.setId(UUID.randomUUID().toString());
        try {
            PreparedStatement damageReport = DBConnection.statement(
                    "INSERT INTO DamageReport " +
                            "(Date, " +
                            "RentalAgreementId) " +
                            "VALUES (?, ?)");
            damageReport.setDate(1, newDamageReport.getDate());
            damageReport.setInt(2, newDamageReport.getId());
            damageReport.executeUpdate();
        } catch (SQLException e) {
            printDbError(e);
            return false;
        }
        return true;
    }

    public Boolean addDamage(Damage newDamage) {
        try {
            PreparedStatement damages = DBConnection.statement(
                    "INSERT INTO Damage " +
                            "(Type, " +
                            "Description, " +
                            "Date, " +
                            "Cost, " +
                            "Id, " +
                            "DamageReportId)");
            damages.setString(1, newDamage.getType());
            damages.setString(2, newDamage.getDescription());
            damages.setDate(3, (Date) newDamage.getDate());
            damages.setDouble(4, newDamage.getCost());
            damages.setInt(5, newDamage.getId());
            damages.setInt(6, newDamage.getDamageReportId());

        } catch (SQLException e) {
            printDbError(e);
            return false;
        }
        return true;
    }

    public void printDbError(SQLException dbError) {
        System.out.println("Database error.");
        dbError.printStackTrace();
    }
}
/*

@Service
public class MySQLRegistrationAdder {
    public MySQLRegistrationAdder() {
    }

    public Boolean add(RentalAgreement agreement) {
        try {
            var prepared = DBConnection.statement(statement());
            initValues(prepared,agreement).execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private String statement(){
        return """
        insert into RentalAgreement (StartDate,
                                    ExpirationDate,
                                    DeliveryDate,
                                    Payment,
                                    Id, CarNumber,
                                    CustomerLicense_Id)
        values (?,?,?,?,?,?,?);
        """;
    }

    private PreparedStatement initValues(PreparedStatement statement, RentalAgreement agreement) throws SQLException {
        statement.setDate(1,toDate(agreement.getStart()));
        statement.setDate(2,toDate(agreement.getExpiration()));
        statement.setDate(3,toDate(agreement.getDelevery()));
        statement.setDouble(4,agreement.getPayment());
        statement.setString(5,agreement.getId());
        statement.setString(6,agreement.getCar().getCarNumber());
        statement.setString(7,agreement.getCustomer().getLicenseID());
        return statement;
    }

    private Date toDate(LocalDate date){
        return Date.valueOf(date);
    }
        }*/

