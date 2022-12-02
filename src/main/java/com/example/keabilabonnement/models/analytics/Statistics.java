package com.example.keabilabonnement.models.analytics;

public class Statistics {
    private double revenue;
    private int activeSubscriptions;
    private int inactiveSubscription;
    private int total;

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getActiveSubscriptions() {
        return activeSubscriptions;
    }

    public void setActiveSubscriptions(int activeSubscriptions) {
        this.activeSubscriptions = activeSubscriptions;
    }

    public int getInactiveSubscription() {
        return inactiveSubscription;
    }

    public void setInactiveSubscription(int inactiveSubscription) {
        this.inactiveSubscription = inactiveSubscription;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
