package org.app.assignment1;

public interface Payable {
	double getAmount();

	String getPayableTo();

	// Method to display a cheque
	void displayCheque();
}
