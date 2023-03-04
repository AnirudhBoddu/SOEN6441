package main.java.util;

import java.util.Scanner;

public class Helper {
    private static Scanner input = new Scanner(System.in);

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
        System.out.println("Enter y/n please !!");
        return input.next();
    }
}
