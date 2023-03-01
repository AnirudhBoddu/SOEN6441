package main.java.controllers;

import main.java.models.Address;

import java.util.Scanner;

public class AddressController {

    private static AddressController instance = new AddressController();

    // Singleton
    private AddressController() {
    }

    public Address makeAddress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the address details:");

        System.out.println("Street number:");
        String streetNumber = scanner.nextLine();

        System.out.println("Street name:");
        String streetName = scanner.nextLine();

        System.out.println("City:");
        String city = scanner.nextLine();

        System.out.println("Province:");
        String province = scanner.nextLine();

        System.out.println("Postal code:");
        String postalCode = scanner.nextLine();

        return new Address(streetNumber, streetName, city, province, postalCode);
    }

    public static AddressController getInstance() {
        if (instance == null) {
            instance = new AddressController();
        }
        return instance;
    }
}
