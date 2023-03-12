package main.java;

import main.java.controllers.LeaseController;
import main.java.controllers.MenuController;
import main.java.models.*;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

public class RealEstateManagementSystem {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        System.out.println("Real Estate Management System");
        displayMenu();
    }

    private static void displayMenu() {
        MenuController.getInstance().runMenu();
    }
}
