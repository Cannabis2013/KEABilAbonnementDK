package com.example.keabilabonnement.contracts.inspection;

import com.example.keabilabonnement.models.inspection.Report;

import java.util.List;


public interface InspectionRepository {
    boolean addReport(Report report);
    boolean removeReport(String id);
    Report getReportByRental(String id);
    List<Report> getAllReports();
    List<Report> getAllReportsByCarNumber(String rentalID);
    boolean updateReport(Report report);
}
