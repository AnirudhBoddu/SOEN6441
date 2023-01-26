package org.app.assignment1;

public abstract class Employee implements Payable {
    private String firstName;
    private String lastName;
    private int age;
    private int ID;

    public Employee(String firstName, String lastName, int age, int id) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setID(id);
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

    public void setID(int iD) {
        ID = iD;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
