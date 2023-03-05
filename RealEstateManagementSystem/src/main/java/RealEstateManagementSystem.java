package main.java;

import main.java.controllers.MenuController;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class RealEstateManagementSystem {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        System.out.println("Real Estate Management System");
        displayMenu();
    }

    private static void displayMenu() {
        MenuController.getInstance().runMenu();
    }
}
