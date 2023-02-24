package main.java.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import main.java.Database;
import main.java.controllers.MenuController;
import main.java.controllers.PropertyController;
import main.java.models.Address;
import main.java.models.Lease;
import main.java.models.Payment;
import main.java.models.Property;
import main.java.models.PropertySpecification;
import main.java.models.Tenant;
import main.java.services.ApartmentFactory;
import main.java.services.CondoFactory;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;

public class LeaseController {

    private static LeaseController instance = new LeaseController();

    // Singleton
    private LeaseController(){}

    public static LeaseController getInstance(){
        if(instance == null)
            instance = new LeaseController();

        return instance;
    }

    public boolean rentUnit(Property unit, Tenant tenant, Date startDate, Date endDate){
        if(unit.isOccupied()) return false;
        Lease newLease = new Lease(tenant, unit, unit.getRentAmount(), startDate, endDate);
        Database.getInstance().addLease(newLease);
        System.out.println("Lease added successfully");
        return true;
    }
}
