package main.java.controllers;

import main.java.Database;
import main.java.models.Lease;
import main.java.models.Property;
import main.java.models.Tenant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LeaseController {

    private static LeaseController instance = new LeaseController();
    private static Database databaseInstance = Database.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    // Singleton
    private LeaseController() {
    }

    public static LeaseController getInstance() {
        if (instance == null) {
            instance = new LeaseController();
        }
        return instance;
    }

    public void rentUnit() throws ParseException {
        System.out.println("Please enter Property ID");
        int propertyId = scanner.nextInt();
        System.out.println("Please enter Tenant ID");
        int tenantId = scanner.nextInt();

        System.out.println("Please enter Start Date - dd/MM/yyyy");
        Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.next());

        System.out.println("Please enter End Date - dd/MM/yyyy");
        Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.next());

        Property unit = Database.getInstance().getPropertyById(propertyId);
        Tenant tenant = Database.getInstance().getTenantById(tenantId);

        if (!unit.isOccupied()) {
            Lease newLease = new Lease(tenant, unit, unit.getRentAmount(), startDate, endDate);
            Database.getInstance().addLease(newLease);
        }
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
