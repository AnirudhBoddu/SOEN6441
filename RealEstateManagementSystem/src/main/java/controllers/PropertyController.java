package main.java.controllers;

import main.java.Database;
import main.java.models.Address;
import main.java.models.Property;
import main.java.models.PropertySpecification;
import main.java.services.ApartmentFactory;
import main.java.services.CondoFactory;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;

import java.util.List;
import java.util.Scanner;

public class PropertyController {

    private static PropertyController instance = new PropertyController();
    private static Scanner scanner = new Scanner(System.in);

    // Singleton
    private PropertyController() {
    }

    public static PropertyController getInstance() {
        if (instance == null) instance = new PropertyController();

        return instance;
    }

    public void addProperty() {
        System.out.println("What type of property would you like to add? (1) House (2) Condo (3) Apartment");
        int propertyType = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the civic address:");
        String civicAddress = scanner.nextLine();

        Address address = AddressController.getInstance().makeAddress();

        System.out.println("Please enter the property specifications:");

        System.out.println("Number of bedrooms:");
        int numBedrooms = scanner.nextInt();

        System.out.println("Number of bathrooms:");
        int numBathrooms = scanner.nextInt();

        System.out.println("Square footage:");
        int squareFootage = scanner.nextInt();

        System.out.println("Rent amount:");
        double rentAmount = scanner.nextDouble();

        PropertySpecification propertySpecification = new PropertySpecification(numBedrooms, numBathrooms, squareFootage);

        PropertyFactory propertyFactory;
        String unitNum = null;
        switch (propertyType) {
            case 1:
                propertyFactory = new HouseFactory();
                break;
            case 2:
                propertyFactory = new CondoFactory();
                System.out.println("Please enter the unit number:");
                unitNum = scanner.next();
                break;
            case 3:
                propertyFactory = new ApartmentFactory();
                System.out.println("Please enter the apartment number:");
                unitNum = scanner.next();
                break;
            default:
                System.out.println("Invalid property type selected.");
                return;
        }
        Property property = propertyFactory.createProperty(civicAddress, address, propertySpecification, unitNum, rentAmount);
        Database.getInstance().addProperty(property);
    }

    // Method
    // Display all properties in the database
    public void displayProperties() {
        List<Property> listOfProperties = Database.getInstance().getProperties();
        for (Property p : listOfProperties) {
            System.out.println(p);
        }
    }

}
