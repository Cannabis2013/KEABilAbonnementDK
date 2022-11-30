package com.example.keabilabonnement.services.factories.registration;

import com.example.keabilabonnement.models.inspection.Damage;
import com.example.keabilabonnement.models.inspection.Report;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DamageReportFactory {

    public Damage damageFromResultSet(ResultSet set) throws SQLException {
        Damage damage = new Damage();
        damage.setId(set.getString("Damage.Id"));
        damage.setDate(set.getDate("Damage.Date").toLocalDate());
        damage.setType(set.getString("Damage.Type"));
        damage.setDescription(set.getString("Damage.Description"));
        damage.setCost(set.getDouble("Damage.Cost"));
        damage.setReportID(set.getString("Damage.DamageReportId"));
        return damage;
    }

    public Report reportFromResultSet(ResultSet set) throws SQLException {
        Report report = new Report();
        report.setDate(set.getDate("Date").toLocalDate());
        report.setId(set.getString("Id"));
        report.setRentalId(set.getString("RentalAgreementId"));
        return report;
    }
}
