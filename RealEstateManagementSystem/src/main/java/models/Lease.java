package main.java.models;

import java.time.LocalDate;

public class Lease {
    private static int counter = 0;
    private int leaseId;
    private Tenant tenant;
    private Property property;
    private double rentAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;

    private Boolean isPaid;

    public Lease(Tenant tenant, Property property, double rentAmount, LocalDate startDate, LocalDate endDate) {
        this.tenant = tenant;
        this.property = property;
        this.rentAmount = rentAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = false;
        leaseId = ++counter;
        isPaid = false;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public int getLeaseId() {
        return leaseId;
    }


    public Property getProperty() {
        return property;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean paymentStatus) {
        this.isPaid = paymentStatus;
    }

    @Override
    public String toString() {
        return "Lease {" +
                "ID=" + leaseId +
                ", tenant=" + tenant +
                ", property=" + property +
                ", rentAmount=" + rentAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isActive=" + isActive +
                '}';
    }
}

