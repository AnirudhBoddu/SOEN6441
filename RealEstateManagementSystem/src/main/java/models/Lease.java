package main.java.models;

import java.util.Date;

public class Lease {
	   private Tenant tenant;
	   private Property property;
	   private double rentAmount;
	   private Date startDate;
	   private Date endDate;

	   public Lease(Tenant tenant, Property property, double rentAmount, Date startDate, Date endDate) {
	       this.tenant = tenant;
	       this.property = property;
	       this.rentAmount = rentAmount;
	       this.startDate = startDate;
	       this.endDate = endDate;
	   }

	   public Tenant getTenant() {
	       return tenant;
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
	}

