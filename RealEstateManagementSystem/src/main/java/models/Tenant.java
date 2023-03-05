package main.java.models;

import java.util.ArrayList;
import java.util.List;

public class Tenant implements Observer {

    private static int counter = 0;
    private int tenantId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Subject> registeredProperties;

    public Tenant(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        registeredProperties = new ArrayList<>();
        tenantId = ++counter;
    }

    public int getTenantId() {
        return tenantId;
    }

    // Getters and setters for all fields
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void update() {
        for (Subject sub : registeredProperties) {
            String msg = (String) sub.getUpdate(this);
            if (msg == null) {
                System.out.println(firstName + ":: No new message");
            } else System.out.println(firstName + ":: Consuming message::" + msg);
        }
    }

    @Override
    public void update(Property p) {
        String msg = (String) p.getUpdate(this);
        if (msg == null) {
            System.out.println(firstName + ":: No new message");
        } else System.out.println(firstName + ":: Consuming message::" + msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.registeredProperties.add(sub);
    }

    @Override
    public String toString() {
        return "Tenant {" +
                "ID=" + tenantId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\''
                + '}';
    }
}
