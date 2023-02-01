package org.app.assignment1;

import java.time.LocalDate;
import java.time.Month;

/**
 * This class is a template for a utility Bill
 * which implements Payable interface
 *
 * @authors ANIRUDH BODDU & SHAFIQ IMTIAZ
 */
public class Bill implements Payable {
    private String companyName;
    private double amount;
    private LocalDate date;

    /**
     * Bill Constructor
     */
    public Bill(String companyName, double amount, int day, int monthNumber, int year) {
        this.companyName = companyName;
        this.amount = amount;
        Month m = Month.of(monthNumber);
        date = LocalDate.of(year, m.getValue(), day);
    }

    // *********************** OVERRIDDEN METHODS ***********************

    /**
     * @return the bill amount entered during record creation
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * @return name of the company
     */
    @Override
    public String getPayableTo() {
        return companyName;
    }

    /**
     * Method to display a cheque
     */
    @Override
    public void displayCheque() {
        System.out.println("Payable to: " + getPayableTo());
        System.out.println("Due date: " + dueDate());
        System.out.println("Amount: $" + getAmount());
    }

    /**
     * @return cheque date
     */
    @Override
    public LocalDate getDate() {
        return date;
    }

    // *********************** OTHER METHODS ***********************

    /**
     * set a new bill amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * sets company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return cheque date as string
     */
    public String dueDate() {
        return getDate().toString();
    }
}
