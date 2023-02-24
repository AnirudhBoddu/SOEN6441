package main.java.controllers;

import java.util.Scanner;

import main.java.Database;
import main.java.RealEstateManagementSystem;
import main.java.models.Address;
import main.java.models.Property;
import main.java.models.PropertySpecification;
import main.java.services.ApartmentFactory;
import main.java.services.CondoFactory;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;

public class PropertyController {

    private static PropertyController instance = new PropertyController();

    // Singleton
    private PropertyController(){}

    public static PropertyController getInstance(){
        if(instance == null)
            instance = new PropertyController();

        return instance;
    }

    public void addProperty() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of property would you like to add? (1) House (2) Condo (3) Apartment");
        int propertyType = scanner.nextInt();
        scanner.nextLine();

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

        System.out.println("Rent amount:");
        double rentAmount = scanner.nextDouble();

        PropertySpecification propertySpecification = new PropertySpecification(numBedrooms, numBathrooms,
                squareFootage);

        PropertyFactory propertyFactory;
        String unitNum = null;
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
        Property property = propertyFactory.createProperty(civicAddress, address, propertySpecification, unitNum, rentAmount);
        Database.getInstance().addProperty(property);

        System.out.println("Property added successfully!");
    }

}
