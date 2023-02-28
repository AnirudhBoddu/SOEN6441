package main.java.controllers;

import main.java.Database;
import main.java.models.Tenant;

import java.util.List;

public class TenantController {

    private static TenantController instance = new TenantController();

    // Singleton
    private TenantController(){}

    public static TenantController getInstance(){
        if(instance == null)
            instance = new TenantController();

        return instance;
    }

    public void displayTenants() {
        List<Tenant> listOfTenants = Database.getInstance().getTenants();

        for(Tenant tenant : listOfTenants)
            System.out.println(tenant.toString());
    }
}
