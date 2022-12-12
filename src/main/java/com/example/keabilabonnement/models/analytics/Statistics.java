package com.example.keabilabonnement.models.analytics;

public class Statistics {
    private double revenue;
    private int availableCars;
    private int unavailableCars;

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(int availableCars) {
        this.availableCars = availableCars;
    }

    public int getUnavailableCars() {
        return unavailableCars;
    }

    public void setUnavailableCars(int unavailableCars) {
        this.unavailableCars = unavailableCars;
    }

}
