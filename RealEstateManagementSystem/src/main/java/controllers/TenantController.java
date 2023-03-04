package main.java.controllers;

import main.java.Database;
import main.java.models.Tenant;
import main.java.util.Helper;

import java.util.List;
import java.util.Scanner;

public class TenantController {

    private static TenantController instance = new TenantController();
    private static Scanner input = new Scanner(System.in);

    // Singleton
    private TenantController() {
    }

    public void addTenant() {
        System.out.println("Please enter first name:");
        Helper.checkAlpha(input);
        String firstName = input.next();

        System.out.println("Please enter last name:");
        Helper.checkAlpha(input);
        String lastName = input.next();

        System.out.println("Please enter email:");
        String email = input.next();

        System.out.println("Please enter phone number:");
        Helper.checkInteger(input);
        int phoneNumber = input.nextInt();


        Tenant tenant = new Tenant(firstName, lastName, email, phoneNumber);
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
