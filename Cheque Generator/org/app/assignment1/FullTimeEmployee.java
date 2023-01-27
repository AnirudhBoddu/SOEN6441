package org.app.assignment1;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {
    private double salary;

    public FullTimeEmployee(String firstName, String lastName, int age, int ID, double salary) {
        super(firstName, lastName, age, ID);
        this.salary = salary;
    }

    /**
     * Returns salary entered during employee record creation
     */
    @Override
    public double getAmount() {
        return salary;
    }

    /**
     * Returns name of the employee
     */
    @Override
    public String getPayableTo() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public void displayCheque() {
        System.out.println("Payable to: " + getPayableTo());
        System.out.println("Amount: $" + getAmount());
    }

	@Override
	public LocalDate getDate() {
		return date;
	}
}
