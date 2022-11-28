package com.example.keabilabonnement.repository.inspection.update;

import com.example.keabilabonnement.models.inspection.Report;

public interface DbInspectionUpdater {
    boolean update(Report report);
}
