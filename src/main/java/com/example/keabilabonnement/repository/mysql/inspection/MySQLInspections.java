package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.models.inspection.Damage;
import com.example.keabilabonnement.models.inspection.Report;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import com.example.keabilabonnement.services.db.DBConnection;
import com.example.keabilabonnement.services.factories.registration.DamageReportFactory;
import com.example.keabilabonnement.services.factories.registration.RentalAgreementFactory;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MySQLInspections {

    public MySQLInspections(RentalAgreementFactory rentalFactory, DamageReportFactory damageFactory) {
        this.rentalFactory = rentalFactory;
        this.damageFactory = damageFactory;
    }

    public Report getInspectionByRental(String rentalID) {
        String sql = """
                SELECT *
                FROM DamageReport
                INNER JOIN Damage
                ON DamageReport.Id = Damage.DamageReportId
                INNER JOIN RentalAgreement
                ON DamageReport.RentalAgreementId = RentalAgreement.Id
                INNER JOIN Car
                ON RentalAgreement.CarNumber = Car.Number
                INNER JOIN Customer
                ON RentalAgreement.CustomerLicense_Id = Customer.License_Id
                WHERE DamageReport.RentalAgreementId = ?;
                """;
        try {
            PreparedStatement query = DBConnection.statement(sql);
            query.setString(1, rentalID);
            ResultSet set = query.executeQuery();
            Report report = damageFactory.reportFromResultSet(set);
            RentalAgreement agreement = rentalFactory.fromResultSet(set);
            report.setRentalAgreement(agreement);
            while (set.next()) {
                Damage damage = damageFactory.damageFromResultSet(set);
                report.addDamage(damage);
            }
            return report;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Report> getAllInspections() {
        String sql = """
                SELECT *
                FROM DamageReport
                INNER JOIN Damage
                ON DamageReport.Id = Damage.DamageReportId
                INNER JOIN RentalAgreement
                ON DamageReport.RentalAgreementId = RentalAgreement.Id
                INNER JOIN Car
                ON RentalAgreement.CarNumber = Car.Number
                INNER JOIN Customer
                ON RentalAgreement.CustomerLicense_Id = Customer.License_Id;
                """;
        try {
            PreparedStatement query = DBConnection.statement(sql);
            ResultSet set = query.executeQuery();
            return extractReports(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    public List<Report> getAllInspectionsByCarNumber(String number) {
        String sql = """
                SELECT *
                FROM DamageReport
                INNER JOIN Damage
                ON DamageReport.Id = Damage.DamageReportId
                INNER JOIN RentalAgreement
                ON DamageReport.RentalAgreementId = RentalAgreement.Id
                INNER JOIN Car
                ON RentalAgreement.CarNumber = Car.Number
                INNER JOIN Customer
                ON RentalAgreement.CustomerLicense_Id = Customer.License_Id
                WHERE Car.Number = ?;
                """;
        try {
            PreparedStatement query = DBConnection.statement(sql);
            query.setString(1, number);
            ResultSet set = query.executeQuery();
            return extractReports(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private List<Report> extractReports(ResultSet set) throws SQLException {
        List<Report> reports = new ArrayList<>();
        List<Damage> damages = new ArrayList<>();
        List<RentalAgreement> agreements = new ArrayList<>();
        while (set.next()) {
            RentalAgreement agreement = rentalFactory.fromResultSet(set);
            Report report = damageFactory.reportFromResultSet(set);
            Damage damage = damageFactory.damageFromResultSet(set);
            agreements.add(agreement);
            reports.add(report);
            damages.add(damage);
        }
        reports.forEach(report -> {
            for (RentalAgreement agreement : agreements) {
                if (report.getRentalId() == agreement.getId()) {
                    report.setRentalAgreement(agreement);
                    break;
                }
            }
            for (Damage damage : damages) {
                if (damage.getReportID() == report.getId())
                    report.addDamage(damage);
            }
        });
        return reports;
    }

    private final RentalAgreementFactory rentalFactory;
    private final DamageReportFactory damageFactory;
}
