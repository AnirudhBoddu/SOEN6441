package main.java.controllers;

import main.java.Database;
import main.java.models.Address;
import main.java.models.Property;
import main.java.models.PropertySpecification;
import main.java.models.Tenant;
import main.java.services.ApartmentFactory;
import main.java.services.CondoFactory;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;
import main.java.util.Helper;

import java.util.List;
import java.util.Scanner;

public class PropertyController {

    private static PropertyController instance = new PropertyController();
    private static final Scanner input = new Scanner(System.in);

    // Singleton
    private PropertyController() {
    }

    public static PropertyController getInstance() {
        if (instance == null) instance = new PropertyController();

        return instance;
    }

    public void addProperty() {
        System.out.println("What type of property would you like to add? (1) House (2) Condo (3) Apartment");
        Helper.checkInteger(input);
        int propertyType = input.nextInt();

        System.out.println("Please enter the civic address:");
        String civicAddress = input.next();

        Address address = AddressController.getInstance().makeAddress();
        input.nextLine();

        System.out.println("Please enter the property specifications:");

        System.out.println("Number of bedrooms:");
        Helper.checkInteger(input);
        int numBedrooms = input.nextInt();

        System.out.println("Number of bathrooms:");
        Helper.checkInteger(input);
        int numBathrooms = input.nextInt();

        System.out.println("Square footage:");
        Helper.checkInteger(input);
        int squareFootage = input.nextInt();

        System.out.println("Rent amount:");
        Helper.checkDouble(input);
        double rentAmount = input.nextDouble();

        PropertySpecification propertySpecification = new PropertySpecification(numBedrooms, numBathrooms,
                squareFootage);

        PropertyFactory propertyFactory;
        String unitNum = null;
        switch (propertyType) {
            case 1 -> propertyFactory = new HouseFactory();
            case 2 -> {
                propertyFactory = new CondoFactory();
                System.out.println("Please enter the unit number:");
                unitNum = input.next();
            }
            case 3 -> {
                propertyFactory = new ApartmentFactory();
                System.out.println("Please enter the apartment number:");
                unitNum = input.next();
            }
            default -> {
                System.out.println("Invalid property type selected.");
                return;
            }
        }
        Property property = propertyFactory.createProperty(civicAddress, address, propertySpecification, unitNum,
                rentAmount);
        Database.getInstance().addProperty(property);
    }

    public void registerTenantToProperty() {
        System.out.println("Please enter the Property ID:");
        Helper.checkInteger(input);
        int propertyID = input.nextInt();

        System.out.println("Please enter the Tenant ID:");
        Helper.checkInteger(input);
        int tenantID = input.nextInt();

        Property observable = Database.getInstance().getPropertyById(propertyID);
        Tenant observer = Database.getInstance().getTenantById(tenantID);

        observable.register(observer);
        System.out.println(observer.getFirstName() + " subscribed to " + observable.getCivicAddress() + " - " + observable.getAddress());
    }

    // Method
    // Display all properties in the database
    public void displayProperties() {
        List<Property> listOfProperties = Database.getInstance().getProperties();
        if (listOfProperties.isEmpty()) {
            System.out.println("The are no registered properties.");
            return;
        }
        for (Property p : listOfProperties) {
            System.out.println(p);
        }
    }

}
