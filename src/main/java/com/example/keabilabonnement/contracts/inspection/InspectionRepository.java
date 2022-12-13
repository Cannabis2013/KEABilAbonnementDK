package com.example.keabilabonnement.contracts.inspection;

import com.example.keabilabonnement.models.inspection.Damage;
import com.example.keabilabonnement.models.inspection.Report;

import java.util.List;


public interface InspectionRepository {

    /*

        Authors: Nikki Deleuran - M. Kaan Arici - Stefan Jensen - Martin Hansen

    */

    boolean addReport(Report report);
    boolean addDamage(Damage damage);
    boolean removeReport(String id);
    boolean deleteDamageById(String id);
    Report getReportByRental(String id);
    List<Report> getAllReports();
    List<Report> getAllReportsByCarNumber(String rentalID);
    boolean updateReport(Report report);
}
