package main.java.controllers;

import main.java.models.Address;
import main.java.util.Helper;

import java.util.Scanner;

public class AddressController {

    private static AddressController instance = new AddressController();

    // Singleton
    private AddressController() {
    }

    public Address makeAddress() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the address details:");

        System.out.println("Street number:");
        Helper.checkInteger(input);
        int streetNumber = input.nextInt();

        System.out.println("Street name:");
        Helper.checkAlpha(input);
        String streetName = input.next();

        System.out.println("City:");
        Helper.checkAlpha(input);
        String city = input.next();

        System.out.println("Province:");
        Helper.checkAlpha(input);
        String province = input.next();

        System.out.println("Postal code:");
        String postalCode = input.next();

        return new Address(streetNumber, streetName, city, province, postalCode);
    }

    public static AddressController getInstance() {
        if (instance == null) {
            instance = new AddressController();
        }
        return instance;
    }
}
