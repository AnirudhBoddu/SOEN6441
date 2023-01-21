package org.app.assignment1;

public class PartTimeEmployee extends Employee {
	private int echelon;
	private int hoursWorkedPerMonth;

	public PartTimeEmployee(String firstName, String lastName, int age, int id, int echelon, int hoursWorkedPerMonth) {
		super(firstName, lastName, age, id);
		this.echelon = echelon;
		this.hoursWorkedPerMonth = hoursWorkedPerMonth;
	}

	@Override
	public double getAmount() {
		return hoursWorkedPerMonth * getHourlyRate();
	}

	private double getHourlyRate() {
		if (echelon == 1)
			return 15.0;
		else if (echelon == 2)
			return 20.0;
		else if (echelon == 3)
			return 25;
		else if (echelon == 4)
			return 30;
		else
			return 40;
	}

	@Override
	public String getPayableTo() {
		return getFirstName() + " " + getLastName();
	}

	@Override
	public void displayCheque() {
		// TODO Auto-generated method stub
		
	}
}
