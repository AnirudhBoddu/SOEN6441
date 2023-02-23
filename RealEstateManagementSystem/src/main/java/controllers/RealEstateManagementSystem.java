package main.java.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.models.Address;
import main.java.models.Lease;
import main.java.models.Payment;
import main.java.models.Property;
import main.java.models.PropertySpecification;
import main.java.models.Tenant;
import main.java.services.ApartmentFactory;
import main.java.services.CondoFactory;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;

public class RealEstateManagementSystem {

	private List<Property> properties;
	private List<Tenant> tenants;
	private List<Lease> leases;
	private List<Payment> payments;
	private Scanner scanner = new Scanner(System.in);

	public RealEstateManagementSystem() {
		properties = new ArrayList<>();
		tenants = new ArrayList<>();
		leases = new ArrayList<>();
		payments = new ArrayList<>();
	}

	public static void main(String[] args) {
		System.out.println("Real Estate Management System");
	}

	private static void displayMenu() {
		System.out.println("Rental Management System Menu");
		System.out.println("-------------------------------");
		System.out.println("1. Add a property");
		System.out.println("2. Add a tenant");
		System.out.println("3. Rent a unit");
		System.out.println("4. Display properties");
		System.out.println("5. Display tenants");
		System.out.println("6. Display rented units");
		System.out.println("7. Display vacant units");
		System.out.println("8. Display all leases");
		System.out.println("9. Exit");
		System.out.println("-------------------------------");
		System.out.print("Please enter your choice (1-9): ");
	}

	public void addProperty() {
		System.out.println("What type of property would you like to add? (1) House (2) Condo (3) Apartment");
		int propertyType = scanner.nextInt();
		scanner.nextLine(); // consume the new line character

		System.out.println("Please enter the civic address:");
		String civicAddress = scanner.nextLine();

		System.out.println("Please enter the address details:");

		System.out.println("Street number:");
		String streetNumber = scanner.nextLine();

		System.out.println("Street name:");
		String streetName = scanner.nextLine();

		System.out.println("City:");
		String city = scanner.nextLine();

		System.out.println("Province:");
		String province = scanner.nextLine();

		System.out.println("Postal code:");
		String postalCode = scanner.nextLine();

		Address address = new Address(streetNumber, streetName, city, province, postalCode);

		System.out.println("Please enter the property specifications:");

		System.out.println("Number of bedrooms:");
		int numBedrooms = scanner.nextInt();

		System.out.println("Number of bathrooms:");
		int numBathrooms = scanner.nextInt();

		System.out.println("Square footage:");
		int squareFootage = scanner.nextInt();

		PropertySpecification propertySpecification = new PropertySpecification(numBedrooms, numBathrooms,
				squareFootage);

		PropertyFactory propertyFactory;
		String unitNum = null; // initialize to null
		switch (propertyType) {
		case 1:
			propertyFactory = new HouseFactory();
			break;
		case 2:
			propertyFactory = new CondoFactory();
			System.out.println("Please enter the unit number:");
			unitNum = scanner.nextLine();
			break;
		case 3:
			propertyFactory = new ApartmentFactory();
			System.out.println("Please enter the apartment number:");
			unitNum = scanner.nextLine();
			break;
		default:
			System.out.println("Invalid property type selected.");
			return;
		}
		Property property = propertyFactory.createProperty(civicAddress, address, propertySpecification, unitNum);
		properties.add(property);
		System.out.println("Property added successfully!");

	}
}
