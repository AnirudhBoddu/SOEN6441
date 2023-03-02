package main.java.controllers;

import main.java.models.Lease;
import main.java.models.Observer;
import main.java.models.Property;
import main.java.models.Subject;

import java.text.ParseException;
import java.util.Scanner;

public class MenuController {

    private static Scanner scanner = new Scanner(System.in);
    private static MenuController instance = new MenuController();

    // Singleton
    private MenuController(){}

    public static MenuController getInstance(){
        if(instance == null)
            instance = new MenuController();

        return instance;
    }

    // TODO SHAFIQ
    // Create infinte loop with proper break to exit system
    public static void runMenu(){
        displayMenu();
        int userInput = scanner.nextInt();

        switch (userInput){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                MenuController.getInstance().displayProperties();
                break;
            case 6:
                MenuController.getInstance().displayTenants();
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                MenuController.getInstance().payRent();
                break;
            case 14:
                MenuController.getInstance().terminateLease();
                break;
            case 13: //TODO Exit
                break;
        }
    }
    //TODO: Implementation of Menu SHAFIQ
    public static void displayMenu() {
        System.out.println("Rental Management System Menu");
        System.out.println("-------------------------------");
        System.out.println("1.  Add a property");        // Property Controller
        System.out.println("2.  Add a tenant");          // Tenant Controller
        System.out.println("3.  Rent a unit");           // Lease Controller
        System.out.println("4.  Subscribe to properties");   // Property Controller
        System.out.println("5.  Display properties");    // Property Controller
        System.out.println("6.  Display tenants");       // Tenant Controller
        System.out.println("7.  Display rented units");  // Lease Controller
        System.out.println("8.  Display vacant units");  // Lease Controller
        System.out.println("9.  Display all leases");    // Lease Controller
        System.out.println("11. Display all outstanding rents");    // Lease Controller
        System.out.println("12. Pay rent");    // Lease Controller
        System.out.println("13. Terminate Lease");
        System.out.println("14. Exit");
        System.out.println("-------------------------------");
        System.out.print("Please enter your choice (1-13): ");
    }

    public void addProperty() {
        PropertyController.getInstance().addProperty();
        System.out.println("Property added successfully!");
    }

    public void registerTenantToProperty(Observer tenant, Subject property){
        TenantController.getInstance().addTenant();
    };

    public void terminateLease(){
        LeaseController.getInstance().terminateLeaseById();
    }

    public void addTenant() {
        TenantController.getInstance().addTenant();
    }

    public void rentUnit() {
        LeaseController.getInstance().rentUnit();
    }


    public void displayProperties() {
        PropertyController.getInstance().displayProperties();
    }


    public void displayTenants() {
        TenantController.getInstance().displayTenants();
    }

    public void displayRentedUnits() {
        LeaseController.getInstance().displayRentedUnits();
    }

    public void displayVacantUnits() {
        LeaseController.getInstance().displayVacantUnits();
    }

    public void displayLeases() {
        LeaseController.getInstance().displayAllLeases();
    }

    // Iterate through list of valid leases (isPaid == false) and display outstanding unpaid leases
    // Display lease id, tenant name, tenant phone number, rent amount
    public void displayUnpaidLeases(){
       LeaseController.getInstance().displayUnpaidLeases();
    }

    // Query for creation of new payment and save in database
    public void payRent(){
        PaymentController.getInstance().createNewPayment();
    }


}
