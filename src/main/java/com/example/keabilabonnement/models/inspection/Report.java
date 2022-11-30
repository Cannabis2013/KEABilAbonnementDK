package com.example.keabilabonnement.models.inspection;

import com.example.keabilabonnement.models.entity.Entity;
import com.example.keabilabonnement.models.registration.RentalAgreement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Report extends Entity {
    private RentalAgreement rentalAgreement;
    private List<Damage> damages = new ArrayList<>();
    private LocalDate date;
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

    public void setDamages(List<Damage> damages) {
        this.damages = damages;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
