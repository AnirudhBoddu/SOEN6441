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
		setProperties(new ArrayList<>());
		setTenants(new ArrayList<>());
		setLeases(new ArrayList<>());
		setPayments(new ArrayList<>());
	}

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	public boolean addProperty(Property property) {
		boolean result = false;
		result = properties.add(property);
		if (result) {
			System.out.println("Property added successfully!");
			return true;
		} else {
			System.out.println("Couldn't add the property");
			return false;
		}
	}

	public void addLease(Lease lease) {
		leases.add(lease);
		System.out.println("Lease added successfully!");
	}

	public void addTenant(Tenant tenant) {
		tenants.add(tenant);
		System.out.println("Tenant added successfully!");
	}


	public void addPayment(Payment payment) {
		payments.add(payment);
		System.out.println("Payment added successfully!");
	}

	public Property getPropertyById(int id) {
		for (Property p : properties) {
			if (p.getPropertyId() == id)
				return p;
		}
		return null;
	}

	public Tenant getTenantById(int id) {
		for (Tenant t : tenants) {
			if (t.getTenantId() == id)
				return t;
		}
		return null;
	}

	public Lease getLeaseById(int id) {
		for (Lease l : leases) {
			if (l.getLeaseId() == id)
				return l;
		}
		return null;
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

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

}
