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

    public Boolean addDamage(Damage newDamage) {//Add damages to damage report.
        try {
            PreparedStatement damages = DBConnection.statement(//Db connection established & MySQL Statement
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
            System.out.println(newDamage.getReportID());
            damages.setString(1, newDamage.getType());//Setting values in
            damages.setString(2, newDamage.getDescription());
            damages.setDate(3, Date.valueOf(newDamage.getDate()));
            damages.setDouble(4, newDamage.getCost());
            damages.setString(5, newDamage.getId());
            damages.setString(6, newDamage.getReportID());
            damages.execute();
        } catch (SQLException e) {//Error message if add doesn't work.
            printDbError(e);
            return false;
        }
        return true;
    }
    //Error message method.
    public void printDbError(SQLException dbError) {
        System.out.println("Database error.");
        dbError.printStackTrace();
    }
}
