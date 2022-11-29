package com.example.keabilabonnement.models.inspection;

import com.example.keabilabonnement.models.registration.RentalAgreement;

import java.time.LocalDate;
import java.util.List;

public class Report {
    private RentalAgreement rentalAgreement;
    private List<Damage> damages;
    private LocalDate date;
    private String id;
    private String rentalId;

    public String getRentalId() {
        return rentalId;
    }

    public void setRentalId(String rentalId) {
        this.rentalId = rentalId;
    }

    public RentalAgreement getRentalAgreement() {
        return rentalAgreement;
    }

    public void setRentalAgreement(RentalAgreement rentalAgreement) {
        this.rentalAgreement = rentalAgreement;
    }

    public List<Damage> getDamages() {
        return damages;
    }

    public void addDamage(Damage damage) {
        this.damages.add(damage);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
