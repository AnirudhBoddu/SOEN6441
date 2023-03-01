package main.java.controllers;

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

    // TODO
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
                break;
            case 6:
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
                break;
            case 13:
                break;
        }
    }
    //TODO: Implementation of Menu
    public static void displayMenu() {
        System.out.println("Rental Management System Menu");
        System.out.println("-------------------------------");
        System.out.println("1. Add a property");        // Property Controller
        System.out.println("2. Add a tenant");          // Tenant Controller
        System.out.println("3. Rent a unit");           // Lease Controller
        System.out.println("4. Subscribe to properties");   // Property Controller
        System.out.println("5. Display properties");    // Property Controller
        System.out.println("6. Display tenants");       // Tenant Controller
        System.out.println("7. Display rented units");  // Lease Controller
        System.out.println("8. Display vacant units");  // Lease Controller
        System.out.println("9. Display all leases");    // Lease Controller

        //TODO
        // Iterate through list of valid leases (isPaid == false) and display outstanding unpaid leases
        // Display lease id, tenant name, tenant phone number, rent amount
        System.out.println("11. Display all outstanding rents");    // Lease Controller

        //TODO
        // Query for creation of new payment and save in database
        System.out.println("12. Pay rent");    // Lease Controller

        //TODO
        System.out.println("13. Exit");
        System.out.println("-------------------------------");
        System.out.print("Please enter your choice (1-9): ");
    }

    public void addProperty() {
        PropertyController.getInstance().addProperty();
        System.out.println("Property added successfully!");
    }

    //TODO
    public void addTenant() {
    }

    //TODO
    public void rentUnit() {

    }

    //TODO
    public void displayProperties() {
        PropertyController.getInstance().displayProperties();
    }

    //TODO
    public void displayTenants() {
        TenantController.getInstance().displayTenants();
    }

    //TODO
    public void displayRentedUnits() {

    }

    //TODO
    public void displayVacantUnits() {

    }

    //TODO
    public void displayLeases() {

    }


}
