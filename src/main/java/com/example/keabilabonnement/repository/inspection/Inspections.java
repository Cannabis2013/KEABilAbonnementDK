package com.example.keabilabonnement.repository.inspection;

import com.example.keabilabonnement.models.inspection.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Inspections {
    public Report getInspectionByRental(String rentalID) {
        return null;
    }

    public Report getInspectionByCarNumber(String number) {
        return null;
    }

    public List<Report> getAllInspections() {
        return null;
    }

    public List<Report> getAllInspectionsByCarNumber(String number) {
        return null;
    }
}
