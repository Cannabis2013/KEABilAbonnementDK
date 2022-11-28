package com.example.keabilabonnement.repository.inspection;

import com.example.keabilabonnement.models.inspection.Report;

import java.util.List;

public interface InspectionRepository {
    boolean addReport(Report report);
    boolean removeReport(String id);
    Report getReport(String id);
    List<Report> getAllReports();
    List<Report> getAllReports(String rentalID);
    boolean updateReport(Report report);
}
