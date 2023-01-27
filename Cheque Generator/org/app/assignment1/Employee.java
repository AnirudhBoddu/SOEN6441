package org.app.assignment1;

import java.time.LocalDate;

public abstract class Employee implements Payable {
    private String firstName;
    private String lastName;
    private int age;
    private int ID;
    protected LocalDate date;

    public Employee(String firstName, String lastName, int age, int id) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setID(id);
        date = LocalDate.now();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
