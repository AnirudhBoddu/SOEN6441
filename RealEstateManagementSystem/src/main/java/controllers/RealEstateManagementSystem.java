package main.java.controllers;

public class RealEstateManagementSystem {
    
    public static void main(String[] args) {
    	System.out.println("Real Estate Management System");
    }

    private static void displayMenu() {
        System.out.println("Rental Management System Menu");
        System.out.println("-------------------------------");
        System.out.println("1. Add a property");
        System.out.println("2. Add a tenant");
        System.out.println("3. Rent a unit");
        System.out.println("4. Display properties");
        System.out.println("5. Display tenants");
        System.out.println("6. Display rented units");
        System.out.println("7. Display vacant units");
        System.out.println("8. Display all leases");
        System.out.println("9. Exit");
        System.out.println("-------------------------------");
        System.out.print("Please enter your choice (1-9): ");
    }
}

