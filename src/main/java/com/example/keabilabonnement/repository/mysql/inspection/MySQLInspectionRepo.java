package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.contracts.inspection.InspectionRepository;
import com.example.keabilabonnement.contracts.inspection.InspectionUpdater;
import com.example.keabilabonnement.models.inspection.Damage;
import com.example.keabilabonnement.models.inspection.Report;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySQLInspectionRepo implements InspectionRepository {

    /*

        Authors: Martin Hansen - Nikki Deleuran - M. Kaan Arici - Stefan Jensen

    */


    private final MySQLInspectionAdder inspectionAdder;
    private final MySQLInspections inspections;
    private final DbInspectionRemover inspectionRemover;
    private final InspectionUpdater inspectionUpdater;

    @Override
    public boolean addReport(Report report) {
        return inspectionAdder.add(report);
    }

    @Override
    public boolean addDamage(Damage damage) {
        return inspectionAdder.addDamage(damage);
    }

    @Override
    public boolean removeReport(String id) {
        return inspectionRemover.remove(id);
    }

    @Override
    public boolean deleteDamageById(String id) {
        return inspectionRemover.deleteDamageById(id);
    }


    @Override
    public Report getReportByRental(String id) {
        return inspections.getInspectionByRental(id);
    }


    @Override
    public List<Report> getAllReports() {
        return inspections.getAllInspections();
    }

    @Override
    public List<Report> getAllReportsByCarNumber(String number) {
        return inspections.getAllInspectionsByCarNumber(number);
    }

    @Override
    public boolean updateReport(Report report) {
        return inspectionUpdater.update(report);
    }

    public MySQLInspectionRepo(MySQLInspectionAdder inspectionAdder, MySQLInspections inspections, DbInspectionRemover inspectionRemover, MySQLInspectionUpdater inspectionUpdater) {
        this.inspectionAdder = inspectionAdder;
        this.inspections = inspections;
        this.inspectionRemover = inspectionRemover;
        this.inspectionUpdater = inspectionUpdater;
    }
}
