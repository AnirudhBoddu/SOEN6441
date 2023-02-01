package org.app.assignment1;

import java.time.LocalDate;

/**
 * Java class for a Part Time Employee
 * extends Employee abstract class
 * 
 */

public class PartTimeEmployee extends Employee {
    private int echelon;
    private int hoursWorkedPerMonth;

    public PartTimeEmployee(String firstName, String lastName, int age, int id, int echelon, int hoursWorkedPerMonth) {
        super(firstName, lastName, age, id);
        this.echelon = echelon;
        this.hoursWorkedPerMonth = hoursWorkedPerMonth;
    }

    /**
     * Method to calculate the salary
     */
    @Override
    public double getAmount() {
        return hoursWorkedPerMonth * getHourlyRate();
    }

    /**
     * Method to return hourly rate based on the echelon code
     */
    private double getHourlyRate() {
        if (echelon == 1)
            return 15.0;
        else if (echelon == 2)
            return 20.0;
        else if (echelon == 3)
            return 25;
        else if (echelon == 4)
            return 30;
        else if (echelon == 5)
            return 40;
        return 0;
    }

    /**
     * Return name of the employee
     */
    @Override
    public String getPayableTo() {
        return getFirstName() + " " + getLastName();
    }

    /**
     * Displays cheque
     */
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
