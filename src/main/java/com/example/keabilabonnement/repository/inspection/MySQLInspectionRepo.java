package com.example.keabilabonnement.repository.inspection;

import com.example.keabilabonnement.models.inspection.Report;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySQLInspectionRepo implements InspectionRepository{

    private DbInspectionAdd inspectionAdder;
    private Inspections inspections;
    private DbInspectionRemover inspectionRemover;
    private DbInspectionUpdater inspectionUpdater;

    @Override
    public boolean addReport(Report report) {
        return inspectionAdder.add(report);
    }

    @Override
    public boolean removeReport(String id) {
        return inspectionRemover.remove(id);
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

    public MySQLInspectionRepo(DbInspectionAdd inspectionAdder, Inspections inspections, DbInspectionRemover inspectionRemover, DbInspectionUpdater inspectionUpdater) {
        this.inspectionAdder = inspectionAdder;
        this.inspections = inspections;
        this.inspectionRemover = inspectionRemover;
        this.inspectionUpdater = inspectionUpdater;
    }
}
