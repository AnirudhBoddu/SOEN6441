package main.java;

import main.java.controllers.*;
import main.java.models.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RealEstateManagementSystem {

    private static RealEstateManagementSystem instance = new RealEstateManagementSystem();

    // Singleton
    private RealEstateManagementSystem() {
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException {

        //MenuController.runMenu();

        System.out.println("Real Estate Management System");

        System.out.println(CSVReader("res/property.csv"));
        System.out.println(CSVReader("res/tenant.csv"));

        System.out.println("**** Add Property ****");
        PropertyController.getInstance().addProperty();

        System.out.println("**** Add Tenant *****");
        TenantController.getInstance().addTenant();

        System.out.println("**** Rent Unit *****");
        LeaseController.getInstance().rentUnit();

        LeaseController.getInstance().displayAllLeases();
        System.out.println("**** Display UnpaidLeases ****");
        LeaseController.getInstance().displayUnpaidLeases();

        System.out.println("**** Payment Creation ***");
        PaymentController.getInstance().createNewPayment();
        System.out.println("**** Display UnpaidLeases ****");

        LeaseController.getInstance().displayUnpaidLeases();
//        // TEST CASES for Display Properties Functionality
//        System.out.println("****Testing Display Properties Functionality****");
//		Property house1 = new House("Brompfman", new Address("6343","Jarry","Montreal","QC","H2S2V4"),
//	    	new PropertySpecification(4,3,1000), 50.0);
//		Database.getInstance().addProperty(house1);
//
//		Property apartment = new House("Hobs", new Address("6999","Drummond","Montreal","QC","H9S2V4"),
//	    	new PropertySpecification(4,3,1000), 50.0);
//		Database.getInstance().addProperty(apartment);
//        PropertyController.getInstance().displayProperties();
//
////        System.out.println("****Testing Display Tenant Functionality****");
////         TEST CASES for Display Tenants Functionality
//        Tenant tenant1 = new Tenant("Vithu", "Maheswaran", "514-240-0499", "vithu.maheswaran@gmail.com");
//        Tenant tenant2 = new Tenant("Tom", "Ford", "514-990-0799", "tom.ford@gmail.com");
//        Database.getInstance().addTenant(tenant1);
//        Database.getInstance().addTenant(tenant2);
//        TenantController.getInstance().displayTenants();
//
//
////         TESTING Observer Pattern, Using Subject: house1
//        System.out.println("****TESTING OBSERVER PATTERN*****");
////         Register observers to the subject
//        house1.register(tenant1);
//
//        // attach observer to subject
//        tenant1.setSubject(house1);
//
//        // check if any update is available
//        tenant1.update();
//
//        house1.register(tenant2);
//        tenant2.setSubject(house1);
//
//        // now send message to subject
//        house1.setOccupied(false);
//
//        apartment.register(tenant2);
//        tenant2.setSubject(apartment);
//        apartment.setOccupied(false);
    }

    public static RealEstateManagementSystem getInstance() {
        if (instance == null) instance = new RealEstateManagementSystem();
        return instance;
    }

    private static void displayMenu() {
        MenuController.getInstance().displayMenu();
    }

    public static List<List<String>> CSVReader(String filepath) {
        List<List<String>> records = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }


}
