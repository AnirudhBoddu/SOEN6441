package org.app.assignment1;

/**
 * Java class for a Part Time Employee which
 * extends Employee abstract class
 *
 * @authors ANIRUDH BODDU & SHAFIQ IMTIAZ
 */
public class PartTimeEmployee extends Employee {
    private int echelon;
    private int hoursWorkedPerMonth;

    /**
     * Part Time Employee Constructor
     */
    public PartTimeEmployee(String firstName, String lastName, int age, int id, int echelon, int hoursWorkedPerMonth) {
        super(firstName, lastName, age, id);
        this.echelon = echelon;
        this.hoursWorkedPerMonth = hoursWorkedPerMonth;
    }

    // *********************** OVERRIDDEN METHODS ***********************

    /**
     * @return calculate the salary
     */
    @Override
    public double getAmount() {
        return hoursWorkedPerMonth * getHourlyRate();
    }

    /**
     * @return name of the employee
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

    // *********************** OTHER METHODS ***********************

    /**
     * @return hourly rate based on the echelon code
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
     * @return employee echelon
     */
    public int getEchelon() {
        return echelon;
    }

    /**
     * sets employee echelon
     */
    public void setEchelon(int echelon) {
        this.echelon = echelon;
    }

    /**
     * @return hours worked per month
     */
    public int getHoursWorkedPerMonth() {
        return hoursWorkedPerMonth;
    }

    /**
     * sets hours worked per month
     */
    public void setHoursWorkedPerMonth(int hoursWorkedPerMonth) {
        this.hoursWorkedPerMonth = hoursWorkedPerMonth;
    }
}
