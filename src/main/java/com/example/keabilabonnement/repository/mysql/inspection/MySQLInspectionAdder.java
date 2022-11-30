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
            damageReport.setDate(1, Date.valueOf(newDamageReport.getDate()));
            damageReport.setString(2, newDamageReport.getId());
            damageReport.executeUpdate();
        } catch (SQLException e) {
            printDbError(e);
            return false;
        }
        return true;
    }

    public Boolean addDamage(Damage newDamage) {
        newDamage.setId(UUID.randomUUID().toString());
        try {
            PreparedStatement damages = DBConnection.statement(
                    """
                            INSERT INTO Damage
                            (Type,
                            Description,
                            Date,
                            Cost,
                            Id,
                            DamageReportId)
                            VALUES (?, ?, ?, ?, ?, ?)
                            """);
            damages.setString(1, newDamage.getType());
            damages.setString(2, newDamage.getDescription());
            damages.setDate(3, Date.valueOf(newDamage.getDate()));
            damages.setDouble(4, newDamage.getCost());
            damages.setString(5, newDamage.getId());
            damages.setString(6, newDamage.getReportID());

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
