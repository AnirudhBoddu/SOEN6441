package org.app.assignment1;

import java.time.LocalDate;

public interface Payable {
    public double getAmount();

    public String getPayableTo();

    // Method to display a cheque
    public void displayCheque();
    
    public LocalDate getDate();
}
