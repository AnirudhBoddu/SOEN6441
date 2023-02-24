package main.java;

import main.java.models.Lease;
import main.java.models.Payment;
import main.java.models.Property;
import main.java.models.Tenant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    private List<Property> properties;
    private List<Tenant> tenants;
    private List<Lease> leases;
    private List<Payment> payments;
    private Scanner scanner = new Scanner(System.in);

    private static Database instance = new Database();

    // Singleton
    private Database() {
        properties = new ArrayList<>();
        tenants = new ArrayList<>();
        leases = new ArrayList<>();
        payments = new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("Real Estate Management System");
    }

    public static Database getInstance(){
        if(instance == null)
            instance = new Database();
        return instance;
    }

    public void addProperty( Property property) {
        properties.add(property);
        System.out.println("Property added successfully!");
    }

    public void addLease( Lease lease) {
        leases.add(lease);
        System.out.println("Lease added successfully!");
    }

}
