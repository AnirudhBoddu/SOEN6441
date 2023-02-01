package org.app.assignment1;

import java.time.LocalDate;

/**
 * Java Interface for Payable objecs like Employee and Bill.
 * Employee class and Bills class implements this interface.
 *
 * @authors ANIRUDH BODDU & SHAFIQ IMTIAZ
 */
public interface Payable {
    // Method to get payable object amount
    double getAmount();

    // Method to get payable object name
    String getPayableTo();

    // Method to display a cheque
    void displayCheque();

    // Method to get payable object date
    LocalDate getDate();
}
