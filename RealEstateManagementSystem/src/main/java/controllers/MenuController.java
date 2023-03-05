package main.java.controllers;

import main.java.util.Helper;

import java.util.Scanner;

public class MenuController {

    private static final Scanner input = new Scanner(System.in);
    private static MenuController instance = new MenuController();

    // Singleton
    private MenuController() {
    }

    public static MenuController getInstance() {
        if (instance == null) {
            instance = new MenuController();
        }
        return instance;
    }

    public void displayMenu() {
        System.out.println("==================================");
        System.out.println("1.  Add a property");
        System.out.println("2.  Add a tenant");
        System.out.println("3.  Rent a unit");
        System.out.println("4.  Subscribe to properties");
        System.out.println("5.  Display properties");
        System.out.println("6.  Display tenants");
        System.out.println("7.  Display rented units");
        System.out.println("8.  Display vacant units");
        System.out.println("9.  Display all leases");
        System.out.println("10. Display all outstanding rents");
        System.out.println("11. Pay rent");
        System.out.println("12. Terminate Lease");
        System.out.println("13. Populate from CSV");
        System.out.println("14. Exit");
        System.out.println("==================================");
        System.out.print("Please enter your choice (1-14): ");
    }

    // Create infinte loop with proper break to exit system
    public void runMenu() {
        int userInput = 0;
        do {
            displayMenu();
            if (input.hasNextInt()) userInput = input.nextInt();
            else input.next();

            switch (userInput) {
                case 1:
                    MenuController.getInstance().addProperty();
                    break;
                case 2:
                    MenuController.getInstance().addTenant();
                    break;
                case 3:
                    MenuController.getInstance().rentUnit();
                    break;
                case 4:
                    MenuController.getInstance().registerTenantToProperty();
                    break;
                case 5:
                    MenuController.getInstance().displayProperties();
                    break;
                case 6:
                    MenuController.getInstance().displayTenants();
                    break;
                case 7:
                    MenuController.getInstance().displayRentedUnits();
                    break;
                case 8:
                    MenuController.getInstance().displayVacantUnits();
                    break;
                case 9:
                    MenuController.getInstance().displayLeases();
                    break;
                case 10:
                    MenuController.getInstance().displayUnpaidLeases();
                    break;
                case 11:
                    MenuController.getInstance().payRent();
                    break;
                case 12:
                    MenuController.getInstance().terminateLease();
                    break;
                case 13:
                    MenuController.getInstance().populateFromCSV();
                    break;
                case 14:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (userInput != 14);
        System.out.println("Thanks!");
        System.exit(0);
    }

    private void addProperty() {
        PropertyController.getInstance().addProperty();
    }

    private void addTenant() {
        TenantController.getInstance().addTenant();
    }

    private void rentUnit() {
        LeaseController.getInstance().rentUnit();
    }

    private void registerTenantToProperty() {
        PropertyController.getInstance().registerTenantToProperty();
    }

    private void displayProperties() {
        PropertyController.getInstance().displayProperties();
    }

    private void displayTenants() {
        TenantController.getInstance().displayTenants();
    }

    private void displayRentedUnits() {
        LeaseController.getInstance().displayRentedUnits();
    }

    private void displayVacantUnits() {
        LeaseController.getInstance().displayVacantUnits();
    }

    private void displayLeases() {
        LeaseController.getInstance().displayAllLeases();
    }

    // Iterate through list of valid leases (isPaid == false) and display outstanding unpaid leases
    // Display lease id, tenant name, tenant phone number, rent amount
    private void displayUnpaidLeases() {
        LeaseController.getInstance().displayUnpaidLeases();
    }

    // Query for creation of new payment and save in database
    private void payRent() {
        PaymentController.getInstance().createNewPayment();
    }

    private void terminateLease() {
        LeaseController.getInstance().terminateLeaseById();
    }

    private void populateFromCSV() {
        Helper.ParsePropertyCSV(Helper.CSVReader("res/property.csv"));
        Helper.ParseTenantCSV(Helper.CSVReader("res/tenant.csv"));
    }
}
