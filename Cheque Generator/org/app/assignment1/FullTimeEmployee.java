package org.app.assignment1;

/**
 * Java class for a Full Time Employee which
 * extends Employee abstract class
 *
 * @authors ANIRUDH BODDU & SHAFIQ IMTIAZ
 */
public class FullTimeEmployee extends Employee {
    private double salary;

    /**
     * Full Time Employee Constructor
     */
    public FullTimeEmployee(String firstName, String lastName, int age, int ID, double salary) {
        super(firstName, lastName, age, ID);
        this.salary = salary;
    }

    // *********************** OVERRIDDEN METHODS ***********************

    /**
     * @return salary entered during employee record creation
     */
    @Override
    public double getAmount() {
        return salary;
    }

    /**
     * @return name of the employee
     */
    @Override
    public String getPayableTo() {
        return getFirstName() + " " + getLastName();
    }

    /**
     * Method to display pay cheque
     */
    @Override
    public void displayCheque() {
        System.out.println("Payable to: " + getPayableTo());
        System.out.println("Amount: $" + getAmount());
    }

    // *********************** OTHER METHODS ***********************

    /**
     * Method to set salary entered during employee record creation
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
