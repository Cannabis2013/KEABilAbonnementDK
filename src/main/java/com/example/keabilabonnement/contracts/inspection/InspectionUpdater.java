package com.example.keabilabonnement.contracts.inspection;

import com.example.keabilabonnement.models.inspection.Report;

public interface InspectionUpdater {
    boolean update(Report report);
}
