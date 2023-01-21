package org.app.assignment1;

public class FullTimeEmployee extends Employee {
	private double salary;

	public FullTimeEmployee(String firstName, String lastName, int age, int ID, double salary) {
		super(firstName, lastName, age, ID);
		this.salary = salary;
	}

	@Override
	public double getAmount() {
		return salary;
	}

	@Override
	public String getPayableTo() {
		return getFirstName() + " " + getLastName();
	}

	@Override
	public void displayCheque() {
		System.out.println("Payable to: " + getPayableTo());
		System.out.println("Amount: $" + getAmount());
	}
}
