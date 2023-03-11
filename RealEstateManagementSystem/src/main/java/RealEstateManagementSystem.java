package main.java;

import main.java.controllers.LeaseController;
import main.java.controllers.MenuController;
import main.java.models.*;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

public class RealEstateManagementSystem {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        System.out.println("Real Estate Management System");
        displayMenu();
//        PropertyFactory propertyFactory = new HouseFactory();
//        Address address = new Address(321, "Oak St", "Anytown", "Anystate", "67891");
//        PropertySpecification propertySpec = new PropertySpecification(1, 1, 1000);
//        Property p = propertyFactory.createProperty(null, address, propertySpec, null, 1050);
//        Database dbInstance = Database.getInstance();
//        dbInstance.addProperty(p);
//
//        Tenant tenant;
//        String firstName = "John";
//        String lastName = "Doe";
//        String phoneNumber = "1234567890";
//        String email = "johndoe@example.com";
//        tenant = new Tenant(firstName, lastName, email, phoneNumber);
//        dbInstance.addTenant(tenant);
//
//
//        LeaseController.getInstance().displayVacantUnits();


    }

    private static void displayMenu() {
        MenuController.getInstance().runMenu();
    }
}
