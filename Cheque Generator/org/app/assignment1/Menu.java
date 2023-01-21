package org.app.assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	static ArrayList<Payable> payables = new ArrayList<Payable>();
	static int payableCount = 0;
	static int chequeNumber = 1;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int choice;
		String ch;
		do {
			displayMenu();
			choice = input.nextInt();
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
			System.out.println("Do you want to continue?");
			ch = input.next();
		} while (choice != 5 && ch.equalsIgnoreCase("Y"));
		System.out.println("Thanks!");
	}

	private static void populateTestValues() {
		ArrayList<Payable> testPayables = new ArrayList<Payable>();
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
		testPayables.add(new Bill("Hydro Quebec", 48.54, "January", 31, 2023));
		testPayables.add(new Bill("Videotron", 72.35, "January", 30, 2023));
		testPayables.add(new Bill("Fido", 50, "February", 1, 2023));
		setPayables(testPayables);
	}

	public static void displayMenu() {
		System.out.println("Accounts Payable System");
		System.out.println("1. Add an employee");
		System.out.println("2. Add a bill");
		System.out.println("3. Issue cheques");
		System.out.println("4. Populate test values");
		System.out.println("5. Exit");
	}

	public static void addEmployee() {
		System.out.println("Adding an employee...");
		// get employee details from user
		Employee emp;
		System.out.println("Enter first name:");
		String firstName = input.next();
		System.out.println("Enter last name:");
		String lastName = input.next();
		System.out.println("Enter age:");
		int age = input.nextInt();
		System.out.println("Enter id:");
		int id = input.nextInt();
		double salary;
		System.out.println("Is the employee a part-timer? (Y/N)");
		String ch;
		ch = input.next();
		if (ch.equalsIgnoreCase("Y")) {
			System.out.println("Enter the echelon number (1 to 5):");
			int echelon = input.nextInt();
			System.out.println("Enter the number of hours worked:");
			int hoursWorked = input.nextInt();
			emp = new PartTimeEmployee(firstName, lastName, age, id, echelon, hoursWorked);
		} else {
			System.out.println("Enter salary per month:");
			salary = input.nextDouble();
			emp = new FullTimeEmployee(firstName, lastName, age, id, salary);
		}
		payables.add(emp);
	}

	public static void addBill() {
		System.out.println("Adding a bill...");
		// get bill details from user
		System.out.println("Enter company name:");
		String companyName = input.nextLine();
		System.out.println("Enter bill amount:");
		double amount = input.nextDouble();
		System.out.println("Enter month:");
		String month = input.nextLine();
		System.out.println("Enter day:");
		int day = input.nextInt();
		System.out.println("Enter year:");
		int year = input.nextInt();
		Bill bill = new Bill(companyName, amount, month, day, year);
		payables.add(bill);
	}

	public static void issueCheques() {
		System.out.println("Issuing cheques...");
		for (Payable payable : payables) {
			if (payable != null) {
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
				System.out.println("Cheque Number: " + chequeNumber);
				payable.displayCheque();
				chequeNumber++;
			}
		}
	}

	public static ArrayList<Payable> getPayables() {
		return payables;
	}

	public static void setPayables(ArrayList<Payable> payables) {
		Menu.payables = payables;
	}
}
