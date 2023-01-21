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
				System.out.println("Exiting the program...");
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
			}
		} while (choice != 4);
	}

	public static void displayMenu() {
		System.out.println("Accounts Payable System");
		System.out.println("1. Add an employee");
		System.out.println("2. Add a bill");
		System.out.println("3. Issue cheques");
		System.out.println("4. Exit");
	}

	public static void addEmployee() {
		System.out.println("Adding an employee...");
		// get employee details from user
		Employee emp;
		System.out.println("Enter first name:");
		String firstName = input.nextLine();
		System.out.println("Enter last name:");
		String lastName = input.nextLine();
		System.out.println("Enter age:");
		int age = input.nextInt();
		System.out.println("Enter id:");
		int id = input.nextInt();
		double salary;
		System.out.println("Is the employee a part-timer?");
		boolean ch;
		ch = input.nextBoolean();
		if (ch) {
			int echelon = input.nextInt();
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
				System.out.println("Cheque Number: " + chequeNumber);
				payable.displayCheque();
				chequeNumber++;
			}
		}
	}
}
