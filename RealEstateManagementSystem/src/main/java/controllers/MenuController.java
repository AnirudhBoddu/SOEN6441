package main.java.controllers;

import main.java.util.Helper;

import java.util.Scanner;

public class MenuController {

    private static Scanner input = new Scanner(System.in);
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
        System.out.println("1.  Add a property");        // Property Controller
        System.out.println("2.  Add a tenant");          // Tenant Controller
        System.out.println("3.  Rent a unit");           // Lease Controller
        System.out.println("4.  Subscribe to properties");   // Property Controller
        System.out.println("5.  Display properties");    // Property Controller
        System.out.println("6.  Display tenants");       // Tenant Controller
        System.out.println("7.  Display rented units");  // Lease Controller
        System.out.println("8.  Display vacant units");  // Lease Controller
        System.out.println("9.  Display all leases");    // Lease Controller
        System.out.println("10. Display all outstanding rents");    // Lease Controller
        System.out.println("11. Pay rent");    // Lease Controller
        System.out.println("12. Terminate Lease");
        System.out.println("13. Exit");
        System.out.println("==================================");
        System.out.print("Please enter your choice (1-13): ");
    }

    // TODO SHAFIQ
    // Create infinte loop with proper break to exit system
    public void runMenu() {
        int userInput = 0;
        String ch = "";
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
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            if (userInput != 13) {
                System.out.println("Do you want to continue? (y/n)");
                ch = Helper.checkYN(input.next());
            }
        } while (userInput != 13 && (ch.equalsIgnoreCase("y")));
        System.out.println("Thanks!");
    }

    public void addProperty() {
        PropertyController.getInstance().addProperty();
    }

    public void addTenant() {
        TenantController.getInstance().addTenant();
    }

    public void rentUnit() {
        LeaseController.getInstance().rentUnit();
    }

    public void registerTenantToProperty() {
        PropertyController.getInstance().registerTenantToProperty();
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
    public void displayUnpaidLeases() {
        LeaseController.getInstance().displayUnpaidLeases();
    }

    // Query for creation of new payment and save in database
    public void payRent() {
        PaymentController.getInstance().createNewPayment();
    }

    public void terminateLease() {
        LeaseController.getInstance().terminateLeaseById();
    }
}
