package main.java.controllers;

import main.java.Database;
import main.java.models.Lease;
import main.java.models.Property;
import main.java.models.Tenant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeaseController {

    private static LeaseController instance = new LeaseController();
    private static Scanner input = new Scanner(System.in);

    // Singleton
    private LeaseController() {
    }

    public static LeaseController getInstance() {
        if (instance == null) {
            instance = new LeaseController();
        }
        return instance;
    }

    public void rentUnit() {
        while (true) {
            try {
                System.out.println("Please enter Property ID");
                int propertyId = input.nextInt();
                System.out.println("Please enter Tenant ID");
                int tenantId = input.nextInt();

                System.out.println("Please enter Start Date - dd/MM/yyyy");
                LocalDate startDate = LocalDate.parse(input.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                System.out.println("Please enter End Date - dd/MM/yyyy");
                LocalDate endDate = LocalDate.parse(input.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                Property unit = Database.getInstance().getPropertyById(propertyId);
                Tenant tenant = Database.getInstance().getTenantById(tenantId);

                if (!unit.isOccupied()) {
                    Lease newLease = new Lease(tenant, unit, unit.getRentAmount(), startDate, endDate);
                    Database.getInstance().addLease(newLease);
                    break;
                }
            } catch (Exception e) {
                System.out.println("You've entered the incorrect format, please try again");
                input.next();
            }
        }
    }

    public void displayRentedUnits() {
        List<Lease> leases = Database.getInstance().getLeases();
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
        List<Property> properties = Database.getInstance().getProperties();
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
        List<Lease> leases = Database.getInstance().getLeases();
        if (leases.isEmpty()) {
            System.out.println("No leases found.");
        } else {
            System.out.println("All Leases:");
            for (Lease lease : leases) {
                System.out.println(lease.toString());
            }
        }
    }

    public void displayUnpaidLeases() {
        List<Lease> leases = Database.getInstance().getLeases();
        if (leases.isEmpty()) {
            System.out.println("No leases found.");
        } else {
            System.out.println("Unpaid Leases:");
            for (Lease lease : leases) {
                if (!lease.isPaid())
                    System.out.println(lease.toString());
            }
        }
    }

    public void terminateLeaseById() {
        System.out.println("Please enter a lease id");
        int leaseId = input.nextInt();
        List<Lease> leases = Database.getInstance().getLeases();
        if (leases.isEmpty()) System.out.println("There are no leases in the system");
        for (int i = 0; i < leases.size(); i++) {
            Lease lease = leases.get(i);
            if (lease.getLeaseId() == leaseId) {
                lease.getProperty().setOccupied(false);
                leases.remove(i);
                break;
            }
        }
    }
}
