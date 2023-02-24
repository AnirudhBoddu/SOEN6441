package main.java.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import main.java.Database;
import main.java.models.Lease;
import main.java.models.Property;
import main.java.models.Tenant;

public class LeaseController {

	private static LeaseController instance = new LeaseController();
	private static Database databaseInstance = Database.getInstance();

	// Singleton
	private LeaseController() {
	}

	public static LeaseController getInstance() {
		if (instance == null)
			instance = new LeaseController();

		return instance;
	}

	public boolean rentUnit(Property unit, Tenant tenant, Date startDate, Date endDate) {
		if (unit.isOccupied())
			return false;
		Lease newLease = new Lease(tenant, unit, unit.getRentAmount(), startDate, endDate);
		Database.getInstance().addLease(newLease);
		System.out.println("Lease added successfully");
		return true;
	}

	public void displayRentedUnits() {
		List<Lease> leases = databaseInstance.getLeases();
		List<Property> rentedProperties = new ArrayList<>();
		for (Lease lease : leases) {
			if (lease.getEndDate() == null) {
				rentedProperties.add(lease.getProperty());
			}
		}
		if (rentedProperties.isEmpty()) {
			System.out.println("No units are currently rented.");
		} else {
			System.out.println("Rented Units:");
			for (Property property : rentedProperties) {
				System.out.println(property.getCivicAddress() + " - " + property.getAddress());
			}
		}
	}

	public void displayVacantUnits() {
		List<Property> properties = databaseInstance.getProperties();
		List<Property> vacantProperties = new ArrayList<>();
		for (Property property : properties) {
			if (!property.isOccupied()) {
				vacantProperties.add(property);
			}
		}
		if (vacantProperties.isEmpty()) {
			System.out.println("No vacant properties available");
			return;
		}
		System.out.println("Vacant Properties:");
		for (Property property : vacantProperties) {
			System.out.println(property.getCivicAddress() + " - " + property.getAddress());
		}
	}

	public void displayAllLeases() {
		List<Lease> leases = databaseInstance.getLeases();
		if (leases.isEmpty()) {
			System.out.println("No leases found.");
		} else {
			System.out.println("All Leases:");
			for (Lease lease : leases) {
				System.out.println(lease.toString());
			}
		}
	}

}
