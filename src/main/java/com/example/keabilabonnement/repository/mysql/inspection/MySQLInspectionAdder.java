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

    /*

        Author: M. Kaan Arici

    */

    public Boolean add(Report newDamageReport) {
        try {
            PreparedStatement damageReport = DBConnection.statement(//Connection established.
                    """
                            INSERT INTO DamageReport
                            (Id, Date, RentalAgreementId)
                            VALUES (?, ?, ?);
                            """);
            damageReport.setString(1, newDamageReport.getId());
            damageReport.setDate(2, Date.valueOf(newDamageReport.getDate()));//Setting values in
            damageReport.setString(3, newDamageReport.getRentalId());
            damageReport.execute();
        } catch (SQLException e) { //Error message if add doesn't work.
            printDbError(e);
            return false;
        }
        return true;
    }

    //Add damage to damage report.
    public Boolean addDamage(Damage newDamage) {
        try {//First statement method from DBConnection is called to establish connection.
            PreparedStatement damages = DBConnection.statement(
                    //MySQL statement for damage entry.
                    """
                            INSERT INTO Damage
                            (Type,
                            Description,
                            Date,
                            Cost,
                            Id,
                            DamageReportId)
                            VALUES (?, ?, ?, ?, ?, ?);
                            """);
            damages.setString(1, newDamage.getType());//Setting values into DB.
            damages.setString(2, newDamage.getDescription());
            damages.setDate(3, Date.valueOf(newDamage.getDate()));
            damages.setDouble(4, newDamage.getCost());
            damages.setString(5, newDamage.getId());
            damages.setString(6, newDamage.getReportID());
            damages.execute(); //Adding to the database is executed.
        } catch (SQLException e) {//Error message if addDamage doesn't work.
            printDbError(e);
            return false;
        }return true;
    }

    //Error message method.
    public void printDbError(SQLException dbError) {
        System.out.println("Database error.");
        dbError.printStackTrace();
    }
}
