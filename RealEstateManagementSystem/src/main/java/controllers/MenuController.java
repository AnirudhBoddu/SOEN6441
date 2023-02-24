package main.java.controllers;

public class MenuController {

    private static MenuController instance = new MenuController();

    // Singleton
    private MenuController(){}

    public static MenuController getInstance(){
        if(instance == null)
            instance = new MenuController();

        return instance;
    }

    //TODO: subscribe to property and send notifications back
    public static void displayMenu() {
        System.out.println("Rental Management System Menu");
        System.out.println("-------------------------------");
        System.out.println("1. Add a property");        // Property Controller
        System.out.println("2. Add a tenant");          // Tenant Controller
        System.out.println("3. Rent a unit");           // Lease Controller
        System.out.println("4. Display properties");    // Property Controller
        System.out.println("5. Display tenants");       // Tenant Controller
        System.out.println("6. Display rented units");  // Lease Controller
        System.out.println("7. Display vacant units");  // Lease Controller
        System.out.println("8. Display all leases");    // Lease Controller
        System.out.println("9. Exit");
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

    }

    //TODO
    public void displayTenants() {

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
