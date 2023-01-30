package org.app.assignment1;

import java.time.LocalDate;
import java.time.Month;

/**
 * This class is a template for a utility Bill 
 * implements Payable interface
 *
 */
public class Bill implements Payable {
    private String companyName;
    private double amount;
    private LocalDate date;

    public Bill(String companyName, double amount, int day, int monthNumber, int year) {
        this.companyName = companyName;
        this.amount = amount;
        Month m = Month.of(monthNumber);
        date = LocalDate.of(year, m.getValue(), day);
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
        return date.toString();
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

    @Override
    public LocalDate getDate() {
        return date;
    }
}
