package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.models.inspection.Report;

import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class MySQLInspectionAdder {

    public void printDbError (SQLException dbError){
        System.out.println("Database error.");
        dbError.printStackTrace();
    }

    public void addDamageReport(Report newDamageReport) {
        try {
            PreparedStatement damageReport = DBConnection.statement("INSERT INTO DamageReport (Date, RentalAgrementId) VALUES (?, ?)");
            damageReport.setTime(1, newDamageReport.getDate());
            damageReport.setInt(2, newDamageReport.getId());
            damageReport.executeUpdate();
        }
        catch (SQLException e){
            printDbError(e);
        }
    public void addDamages(Report newDamages) {


    }


}
