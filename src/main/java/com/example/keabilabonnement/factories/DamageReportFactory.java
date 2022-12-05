package com.example.keabilabonnement.factories;

import com.example.keabilabonnement.models.inspection.Damage;
import com.example.keabilabonnement.models.inspection.Report;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class DamageReportFactory {
    public Report emptyReport() {
        Report report = new Report();
        report.setId(UUID.randomUUID().toString());
        LocalDate date = LocalDate.now();
        report.setDate(date);
        return report;
    }

    public Damage emptyDamage() {
        Damage damage = new Damage();
        damage.setId(UUID.randomUUID().toString());
        return damage;
    }

    public Damage damageFromResultSet(ResultSet set) throws SQLException {
        Damage damage = new Damage();
        String id = set.getString("Damage.id");
        // If id is not set, we can assume the rest of the damage values are null as well
        // as damage for the specific report does not exist then.
        if (id == null)
            return null;
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
