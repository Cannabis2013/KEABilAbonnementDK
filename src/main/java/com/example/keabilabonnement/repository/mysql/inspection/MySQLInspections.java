package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.contracts.agreement.AgreementFactory;
import com.example.keabilabonnement.contracts.shared.Entity;
import com.example.keabilabonnement.models.inspection.Damage;
import com.example.keabilabonnement.models.inspection.Report;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import com.example.keabilabonnement.services.db.DBConnection;
import com.example.keabilabonnement.factories.DamageReportFactory;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MySQLInspections {

    /*
        Author: Stefan Jensen
        Tiny bit refactoring of variable names done by Martin Hansen
    */

    public MySQLInspections(AgreementFactory rentalFactory, DamageReportFactory damageFactory) {
        this.rentalFactory = rentalFactory;
        this.damageFactory = damageFactory;
    }

    public Report getInspectionByRental(String rentalID) {
        String sql = """
                SELECT *
                FROM DamageReport
                LEFT JOIN Damage
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
            Report report = new Report();
            RentalAgreement agreement = new RentalAgreement();
            while (set.next()) {
                if (set.isFirst()) {
                    report = damageFactory.reportFromResultSet(set);
                    agreement = rentalFactory.fromResultSet(set);
                }
                Damage damage = damageFactory.damageFromResultSet(set);
                if (damage != null)
                    report.addDamage(damage);
            }
            report.setRentalAgreement(agreement);
            return report;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Report> getAllInspections() {
        String sql_1 = """
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
            PreparedStatement query = DBConnection.statement(sql_1);
            ResultSet set = query.executeQuery();
            return extractReports(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    public List<Report> getAllInspectionsByCarNumber(String number) {
        String sql_1 = """
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
            PreparedStatement query = DBConnection.statement(sql_1);
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
        List<RentalAgreement> agreements = new ArrayList<>();
        List<Damage> damages = new ArrayList<>();
        while (set.next()) {
            RentalAgreement agreement = rentalFactory.agreementFromResultSet(set);
            Report report = damageFactory.reportFromResultSet(set);
            Damage damage = damageFactory.damageFromResultSet(set);
            damages.add(damage);
            if (!ContainObject(reports, report.getId()))
                reports.add(report);
            if (!ContainObject(agreements, agreement.getId()))
                agreements.add(agreement);
        }

        for (Report report : reports) {
            report.setRentalAgreement(agreements.stream().filter(agreement -> agreement.getId().equals(report.getId())).findFirst().get());
            List<Damage> reportDamages = damages.stream().filter(damage -> damage.getReportID().equals(report.getId())).toList();
            report.setDamages(reportDamages);
        }
        return reports;
    }


    private <T> boolean ContainObject(List<T> objs, String id) {
        for (T obj : objs) {
            if (obj instanceof Entity) {
                if (((Entity) obj).getId().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final AgreementFactory rentalFactory;
    private final DamageReportFactory damageFactory;
}
