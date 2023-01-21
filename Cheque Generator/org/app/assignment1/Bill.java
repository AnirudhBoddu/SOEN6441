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

	public double getAmount() {
		return amount;
	}

	public String getPayableTo() {
		return companyName;
	}

	public String dueDate() {
		return month + "," + day + "," + year;
	}

	@Override
	public void displayCheque() {
		// TODO Auto-generated method stub
		
	}
}
