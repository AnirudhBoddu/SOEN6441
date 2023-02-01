package org.app.assignment1;

import java.time.LocalDate;

/**
 * Employee abstract class implementing Payable interface.
 * This class forms basis for Full-time and Part-time employee classes
 *
 * @authors ANIRUDH BODDU & SHAFIQ IMTIAZ
 */
public abstract class Employee implements Payable {
    private String firstName;
    private String lastName;
    private int age;
    private int ID;
    protected LocalDate date;

    /**
     * Abstract Employee Constructor
     */
    protected Employee(String firstName, String lastName, int age, int id) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setID(id);
        date = LocalDate.now();
    }

    // *********************** OVERRIDDEN METHODS ***********************

    /**
     * @return get Local Date
     */
    @Override
    public LocalDate getDate() {
        return date;
    }

    // *********************** OTHER METHODS ***********************

    /**
     * @return employee first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets employee first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return employee last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets employee last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return employee ID
     */
    public int getID() {
        return ID;
    }

    /**
     * sets employee ID
     */
    public void setID(int id) {
        this.ID = id;
    }

    /**
     * @return employee age
     */
    public int getAge() {
        return age;
    }

    /**
     * sets employee age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
