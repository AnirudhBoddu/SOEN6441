package main.java;

import main.java.models.Lease;
import main.java.models.Payment;
import main.java.models.Property;
import main.java.models.Tenant;

import java.util.ArrayList;
import java.util.List;

public class Database {

	private List<Property> properties;
	private List<Tenant> tenants;
	private List<Lease> leases;
	private List<Payment> payments;
	private static Database instance = new Database();

	// Singleton
	private Database() {
		properties = new ArrayList<>();
		setTenants(new ArrayList<>());
		leases = new ArrayList<>();
		setPayments(new ArrayList<>());
	}

	public static void main(String[] args) {
		System.out.println("Real Estate Management System");
	}

	public static Database getInstance() {
		if (instance == null)
			instance = new Database();
		return instance;
	}

	public void addProperty(Property property) {
		properties.add(property);
		System.out.println("Property added successfully!");
	}

	public void addLease(Lease lease) {
		leases.add(lease);
		System.out.println("Lease added successfully!");
	}

	public void addTenant(Tenant tenant) {
		tenants.add(tenant);
		System.out.println("Tenant added successfully!");
	}

	public List<Lease> getLeases() {
		return leases;
	}

	public void setLeases(List<Lease> leases) {
		this.leases = leases;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public List<Tenant> getTenants() {
		return tenants;
	}

	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}
