package main.java.models;

import java.util.Date;

public class Payment {
	private Lease lease;
	private double amount;
	private Tenant tenant;
	private Date dueDate;
	private Date paidOn;

	public Payment(Lease lease, double amount, Tenant tenant, Date dueDate, Date paidOn) {
		this.lease = lease;
		this.amount = amount;
		this.tenant = tenant;
		this.dueDate = dueDate;
		this.paidOn = paidOn;
	}

	public Lease getLease() {
		return lease;
	}

	public void setLease(Lease lease) {
		this.lease = lease;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaidOn() {
		return paidOn;
	}

	public void setPaidOn(Date paidOn) {
		this.paidOn = paidOn;
	}

}
