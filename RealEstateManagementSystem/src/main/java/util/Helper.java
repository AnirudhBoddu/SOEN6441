package main.java.util;

import main.java.Database;
import main.java.models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Helper {
    private static Scanner input = new Scanner(System.in);

    public static void ParsePropertyCSV(List<List<String>> property) {
        for (List<String> list : property) {
            switch (list.get(0)) {
                case "1":
                    Property house = new House(list.get(1),
                            new Address(Integer.parseInt(list.get(2)), list.get(3), list.get(4), list.get(5), list.get(6)),
                            new PropertySpecification(Integer.parseInt(list.get(7)), Integer.parseInt(list.get(8)),
                                    Integer.parseInt(list.get(9))), Double.parseDouble(list.get(11)));
                    Database.getInstance().addProperty(house);
                    break;
                case "2":
                    Property apartment = new Apartment(list.get(1),
                            new Address(Integer.parseInt(list.get(2)), list.get(3), list.get(4), list.get(5), list.get(6)),
                            new PropertySpecification(Integer.parseInt(list.get(7)), Integer.parseInt(list.get(8)),
                                    Integer.parseInt(list.get(9))), list.get(10), Double.parseDouble(list.get(11)));
                    Database.getInstance().addProperty(apartment);
                    break;
                case "3":
                    Property condo = new Condo(list.get(1),
                            new Address(Integer.parseInt(list.get(2)), list.get(3), list.get(4), list.get(5), list.get(6)),
                            new PropertySpecification(Integer.parseInt(list.get(7)), Integer.parseInt(list.get(8)),
                                    Integer.parseInt(list.get(9))), list.get(10), Double.parseDouble(list.get(11)));
                    Database.getInstance().addProperty(condo);
                    break;
                default:
                    System.out.println("Error");
            }
        }
    }

    public static void ParseTenantCSV(List<List<String>> tenant) {
        for (List<String> list : tenant) {
            Tenant record = new Tenant(list.get(0), list.get(1), list.get(2), list.get(3));
            Database.getInstance().addTenant(record);
        }
    }

    public static List<List<String>> CSVReader(String filepath) {
        List<List<String>> records = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }

    /**
     * Method to verify input is Alphabetic
     */
    public static void checkAlpha(Scanner sc) {
        while (!sc.hasNext("[a-zA-Z]+")) {
            System.out.println("Only alphabets please !!");
            sc.next();
        }
    }

    /**
     * Method to verify input is Integer
     */
    public static void checkInteger(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Only integers please !!");
            sc.next();
        }
    }

    /**
     * Method to verify input is Double
     */
    public static void checkDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Only doubles please !!");
            sc.next();
        }
    }

    /**
     * Method to verify input is Y or N
     */
    public static String checkYN(String ch) {
        while (!ch.equalsIgnoreCase("Y") && !ch.equalsIgnoreCase("n")) {
            System.out.println("Invalid choice !!");
            ch = input.next();
        }
        return ch;
    }
}
