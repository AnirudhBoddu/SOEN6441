package org.app.assignment1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Main class displaying and running the Cheque Generator Menu
 *
 * @authors ANIRUDH BODDU & SHAFIQ IMTIAZ
 */
public class Menu {

    private static final String chequeLineSeparator = "=*=*=*=*=*=*=*=*=*=*=*=";
    private static ArrayList<Payable> payable = new ArrayList<>();
    private static int chequeNumber = 1;
    private static Scanner input = new Scanner(System.in);

    /**
     * Main driver method for the whole program
     */
    public static void main(String[] args) {
        int choice = 0;
        String ch = "";
        do {
            displayMenu();
            if (input.hasNextInt()) choice = input.nextInt();
            else input.next();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    addBill();
                    break;
                case 3:
                    issueCheques();
                    break;
                case 4:
                    populateTestValues();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            if (choice != 5) {
                System.out.println("Do you want to continue? (y/n)");
                ch = input.next();
                checkYN(ch);
            }
        } while (choice != 5 && (ch.equalsIgnoreCase("y")));
        System.out.println("Thanks!");
    }

    /**
     * Method to populate test values on fly
     */
    private static void populateTestValues() {
        ArrayList<Payable> testPayables = new ArrayList<>();
        testPayables.add(new FullTimeEmployee("Cersei", "Lannister", 35, 1001, 60000));
        testPayables.add(new FullTimeEmployee("Grey", "Worm", 32, 1002, 40000));
        testPayables.add(new FullTimeEmployee("Sansa", "Stark", 23, 1003, 55000));
        testPayables.add(new FullTimeEmployee("Arya", "Stark", 18, 1004, 50000));
        testPayables.add(new FullTimeEmployee("Tyrion", "Lannister", 33, 1005, 65000));

        testPayables.add(new PartTimeEmployee("Margaery", "Tyrell", 28, 1006, 3, 60));
        testPayables.add(new PartTimeEmployee("Jon", "Snow", 30, 1007, 5, 70));
        testPayables.add(new PartTimeEmployee("Tywin", "Lannister", 61, 1008, 5, 40));
        testPayables.add(new PartTimeEmployee("Jaime", "Lannister", 35, 1009, 5, 55));
        testPayables.add(new PartTimeEmployee("Ned", "Stark", 55, 1010, 4, 30));

        testPayables.add(new Bill("Hydro Quebec", 48.54, 31, 12, 2019));
        testPayables.add(new Bill("Videotron", 72.35, 3, 4, 2023));
        testPayables.add(new Bill("Fido", 50, 23, 1, 2024));

        setPayable(testPayables);
        System.out.println("Test values populated !!");
    }

    /**
     * Method to display Menu items
     */
    public static void displayMenu() {
        System.out.println(chequeLineSeparator);
        System.out.println("Accounts Payable System");
        System.out.println(chequeLineSeparator);
        System.out.println("1. Add an employee");
        System.out.println("2. Add a bill");
        System.out.println("3. Issue cheques");
        System.out.println("4. Populate test values");
        System.out.println("5. Exit");
        System.out.println(chequeLineSeparator);
    }

    /**
     * Method to add an employee (common for both FT & PT)
     */
    public static void addEmployee() {
        System.out.println("Adding an employee...");
        // get employee details from user

        System.out.println("Enter first name:");
        checkAlpha(input);
        String firstName = input.next();

        System.out.println("Enter last name:");
        checkAlpha(input);
        String lastName = input.next();

        System.out.println("Enter age:");
        checkInteger(input);
        int age = input.nextInt();
        while (age <= 0) {
            System.out.println("Age cannot be less than 1 !!");
            age = input.nextInt();
        }

        System.out.println("Enter id:");
        checkInteger(input);
        int id = input.nextInt();
        while (id < 0) {
            System.out.println("ID cannot be negative !!");
            id = input.nextInt();
        }

        System.out.println("Is the employee a part-timer? (Y/N)");
        String ch = input.next();
        checkYN(ch);

        Employee emp;

        if (ch.equalsIgnoreCase("Y")) {
            System.out.println("Enter the echelon number (1 to 5):");
            checkInteger(input);
            int echelon = input.nextInt();
            while (echelon < 1 || echelon > 5) {
                System.out.println("Echelon can only be between 1 to 5 !!");
                echelon = input.nextInt();
            }
            System.out.println("Enter the number of hours worked:");
            checkInteger(input);
            int hoursWorked = input.nextInt();
            while (hoursWorked < 0) {
                System.out.println("Hours worked cannot be negative!!");
                hoursWorked = input.nextInt();
            }
            emp = new PartTimeEmployee(firstName, lastName, age, id, echelon, hoursWorked);
        } else {
            System.out.println("Enter salary per month:");
            checkDouble(input);
            double salary = input.nextDouble();
            while (salary < 0) {
                System.out.println("Salary cannot be less than 0 !!");
                salary = input.nextDouble();
            }
            emp = new FullTimeEmployee(firstName, lastName, age, id, salary);
        }
        payable.add(emp);
        System.out.println("...Employee added !!");
    }

    /**
     * Method to add a utility bill
     */
    public static void addBill() {
        System.out.println("Adding a bill...");

        // get bill details from user
        System.out.println("Enter company name:");
        checkAlpha(input);
        String companyName = input.nextLine();

        System.out.println("Enter bill amount:");
        checkDouble(input);
        double amount = input.nextDouble();
        while (amount < 0) {
            System.out.println("Bills cannot be negative!!");
            amount = input.nextInt();
        }

        System.out.println("Enter day (dd):");
        checkInteger(input);
        int day = input.nextInt();
        while (day < 1 || day > 31) {
            System.out.println("Date can only be between 1 to 31 !!");
            day = input.nextInt();
        }

        System.out.println("Enter month (mmm):");
        checkAlpha(input);
        String substrMonth = input.next().substring(0, 3).toUpperCase();
        ArrayList<String> monthList = new ArrayList<>(Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"));
        while (!monthList.contains(substrMonth)) {
            System.out.println("Please enter correct month !!");
            substrMonth = input.next().substring(0, 3).toUpperCase();
        }
        int monthNumber = monthList.indexOf(substrMonth) + 1;

        System.out.println("Enter year (yyyy):");
        checkInteger(input);
        int year = input.nextInt();

        Bill bill = new Bill(companyName, amount, day, monthNumber, year);
        payable.add(bill);
        System.out.println("...Bill added !!");
    }

    /**
     * Method to display cheques. Demonstrates polymorphism, we are looping through
     * the input data using the Interface reference.
     */
    public static void issueCheques() {
        System.out.println("Issuing cheques...");
        if (!payable.isEmpty()) {
            Iterator<Payable> iter = payable.iterator();
            while (iter.hasNext()) {
                Payable data = iter.next();
                if (data != null && isPendingCheque(data)) {
                    System.out.println(chequeLineSeparator);
                    System.out.println("Cheque Number: " + chequeNumber);
                    data.displayCheque();
                    chequeNumber++;
                    iter.remove();
                }
            }
            System.out.println(chequeLineSeparator);
            LocalDateTime currDate = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formatDateTime = currDate.format(format);
            System.out.printf("...%d cheques till %s have been issued !!%n", chequeNumber - 1, formatDateTime);
            System.out.println("Number of payable pending: " + payable.size());

            System.out.println("Show pending cheques? (Y/N)");
            String ch = input.next();
            checkYN(ch);
            if (ch.equalsIgnoreCase("Y")) {
                for (Payable data : payable) {
                    if (data != null) {
                        System.out.println(chequeLineSeparator);
                        data.displayCheque();
                    }
                }
                System.out.println(chequeLineSeparator);
            }
        } else {
            System.out.println(chequeLineSeparator);
            System.out.println("...No available cheques to issue !!");
        }
    }

    /**
     * Method to verify whether a cheque must be generated or not.
     *
     * @return boolean whether cheque is pending or not
     */
    private static boolean isPendingCheque(Payable payable) {
        LocalDate chequeDate = payable.getDate();
        LocalDate currentDate = LocalDate.now();
        int chequeMonth = chequeDate.getMonthValue();
        int chequeYear = chequeDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        if (chequeYear == currentYear) {
            return chequeMonth <= currentMonth;
        } else return chequeYear < currentYear;
    }

    /**
     * Method to verify input is Alphabetic
     */
    private static void checkAlpha(Scanner sc) {
        while (!sc.hasNext("[a-zA-Z]+")) {
            System.out.println("Only alphabets please !!");
            sc.next();
        }
        input.nextLine();
    }

    /**
     * Method to verify input is Integer
     */
    private static void checkInteger(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Only integers please !!");
            sc.next();
        }
    }

    /**
     * Method to verify input is Double
     */
    private static void checkDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Only doubles please !!");
            sc.next();
        }
    }

    /**
     * Method to verify input is Y or N
     */
    private static void checkYN(String ch) {
        while (!ch.equalsIgnoreCase("Y") && !ch.equalsIgnoreCase("n")) {
            System.out.println("Please choose only Y/N !!");
            ch = input.next();
        }
    }

    /**
     * @return List of Payable
     */
    public static List<Payable> getPayable() {
        return payable;
    }

    /**
     * Set a new List of Payable
     */
    public static void setPayable(List<Payable> payable) {
        Menu.payable = (ArrayList<Payable>) payable;
    }
}
