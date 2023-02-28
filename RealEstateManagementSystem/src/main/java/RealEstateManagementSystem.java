package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.controllers.MenuController;
import main.java.controllers.PropertyController;
import main.java.controllers.TenantController;
import main.java.models.*;
import main.java.services.ApartmentFactory;
import main.java.services.CondoFactory;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;

public class RealEstateManagementSystem {

	private Scanner scanner = new Scanner(System.in);

	private static RealEstateManagementSystem instance = new RealEstateManagementSystem();

	// Singleton
	private RealEstateManagementSystem() {}

	public static void main(String[] args) {
		System.out.println("Real Estate Management System");

		System.out.println("****Testing Display Properties Functionality****");
		// TEST CASES for Display Properties Functionality
		Property house1 = new House("Brompfman", new Address("6343","Jarry","Montreal","QC","H2S2V4"), new PropertySpecification(4,3,1000), 50.0);
		Database.getInstance().addProperty(house1);
		Property apartment = new House("Hobs", new Address("6999","Drummond","Montreal","QC","H9S2V4"), new PropertySpecification(4,3,1000), 50.0);
		Database.getInstance().addProperty(apartment);
		PropertyController.getInstance().displayProperties();

		System.out.println("****Testing Display Tenant Functionality****");
		// TEST CASES for Display Tenants Functionality
		Tenant tenant1 = new Tenant("Vithu","Maheswaran","514-240-0499","vithu.maheswaran@gmail.com",new Address("6343","Jarry","Montreal","QC","H2S2V4"));
		Tenant tenant2 = new Tenant("Tom","Ford","514-990-0799","tom.ford@gmail.com",new Address("5464","drummond","Montreal","QC","B8S2V4"));
		Database.getInstance().addTenant(tenant1);
		Database.getInstance().addTenant(tenant2);
		TenantController.getInstance().displayTenants();

		// TESTING Observer Pattern, Using Subject: house1
		System.out.println("****TESTING OBSERVER PATTERN*****");
		// Register observers to the subject
		house1.register(tenant1);

		// attach observer to subject
		tenant1.setSubject(house1);

		// check if any update is available
		tenant1.update();

		house1.register(tenant2);
		tenant2.setSubject(house1);

		// now send message to subject
		house1.setOccupied(false);

		apartment.register(tenant2);
		tenant2.setSubject(apartment);
		apartment.setOccupied(false);
	}

	public static RealEstateManagementSystem getInstance(){
		if(instance == null)
			instance = new RealEstateManagementSystem();
		return instance;
	}

	private static void displayMenu() {
		MenuController.getInstance().displayMenu();
	}



}
