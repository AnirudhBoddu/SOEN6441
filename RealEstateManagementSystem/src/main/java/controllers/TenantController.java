package main.java.controllers;

import main.java.Database;
import main.java.models.Tenant;

import java.util.List;
import java.util.Scanner;

public class TenantController {

    private static TenantController instance = new TenantController();
    private static Scanner scanner = new Scanner(System.in);

    // Singleton
    private TenantController() {
    }

    public void addTenant() {
        System.out.println("Please enter first name:");
        String firstName = scanner.next();

        System.out.println("Please enter last name:");
        String lastName = scanner.next();

        System.out.println("Please enter phone number:");
        String phoneNumber = scanner.next();

        System.out.println("Please enter email:");
        String email = scanner.next();

        Tenant tenant = new Tenant(firstName, lastName, phoneNumber, email);
        Database.getInstance().addTenant(tenant);
    }

    public static TenantController getInstance() {
        if (instance == null) {
            instance = new TenantController();
        }
        return instance;
    }

    public void displayTenants() {
        List<Tenant> listOfTenants = Database.getInstance().getTenants();
        for (Tenant tenant : listOfTenants) {
            System.out.println(tenant.toString());
        }
    }
}
