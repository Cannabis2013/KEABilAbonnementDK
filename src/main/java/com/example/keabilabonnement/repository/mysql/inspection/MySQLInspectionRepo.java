package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.contracts.repository.InspectionRepository;
import com.example.keabilabonnement.models.inspection.Report;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySQLInspectionRepo implements InspectionRepository {

    private final MySQLInspectionAdder inspectionAdder;
    private final MySQLInspections inspections;
    private final DbInspectionRemover inspectionRemover;
    private final MySQLInspectionUpdater_imp1 inspectionUpdater;

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

    public MySQLInspectionRepo(MySQLInspectionAdder inspectionAdder, MySQLInspections inspections, DbInspectionRemover inspectionRemover, MySQLInspectionUpdater_imp1 inspectionUpdater) {
        this.inspectionAdder = inspectionAdder;
        this.inspections = inspections;
        this.inspectionRemover = inspectionRemover;
        this.inspectionUpdater = inspectionUpdater;
    }
}
