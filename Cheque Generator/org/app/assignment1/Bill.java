package org.app.assignment1;

public class Bill implements Payable {
	private String companyName;
	private double amount;
	private String month;
	private int day;
	private int year;

	public Bill(String companyName, double amount, String month, int day, int year) {
		this.companyName = companyName;
		this.amount = amount;
		this.month = month;
		this.day = day;
		this.year = year;
	}

	/**
	 * Returns the bill amount entered during record creation
	 */
	@Override
	public double getAmount() {
		return amount;
	}

	/**
	 * Returns name of the company
	 */
	@Override
	public String getPayableTo() {
		return companyName;
	}

	public String dueDate() {
		return month + "," + day + "," + year;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public void displayCheque() {
		System.out.println("Payable to: " + getCompanyName());
		System.out.println("Due date: " + dueDate());
		System.out.println("Amount: $" + getAmount());
	}
}
