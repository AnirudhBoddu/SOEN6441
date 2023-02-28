package main.java.models;

import java.util.Date;

public class Lease {
    private static int counter = 0;
    private int leaseId;
    private Tenant tenant;
    private Property property;
    private double rentAmount;
    private Date startDate;
    private Date endDate;
    private Boolean isActive;

    public Lease(Tenant tenant, Property property, double rentAmount, Date startDate, Date endDate) {
        this.tenant = tenant;
        this.property = property;
        this.rentAmount = rentAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = false;
        leaseId = ++counter;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "leaseId=" + leaseId +
                ", tenant=" + tenant +
                ", property=" + property +
                ", rentAmount=" + rentAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isActive=" + isActive +
                '}';
    }
}

