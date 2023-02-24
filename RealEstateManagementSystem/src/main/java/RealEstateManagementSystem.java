package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.controllers.MenuController;
import main.java.controllers.PropertyController;
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

	private Scanner scanner = new Scanner(System.in);

	private static RealEstateManagementSystem instance = new RealEstateManagementSystem();

	// Singleton
	private RealEstateManagementSystem() {}

	public static void main(String[] args) {
		System.out.println("Real Estate Management System");
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
