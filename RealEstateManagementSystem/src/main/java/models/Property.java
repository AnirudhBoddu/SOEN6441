package main.java.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Property implements Subject {

    private static int counter = 0;
    private final Object MUTEX = new Object();
    private int propertyId;
    private String civicAddress;
    private Address address;
    private PropertySpecification propertySpecification;
    private Boolean isOccupied;
    private double rentAmount;
    // Observer Pattern
    private List<Observer> observers;
    private String message;
    private boolean changed;

    public Property(String civicAddress, Address address, PropertySpecification propertySpecification, double rent) {
        super();
        this.civicAddress = civicAddress;
        this.address = address;
        this.propertySpecification = propertySpecification;
        this.setOccupied(false);
        this.rentAmount = rent;
        this.observers = new ArrayList<>();
        propertyId = ++counter;
    }

    public int getPropertyId() {
        return propertyId;
    }


    public String getCivicAddress() {
        return civicAddress;
    }

    public void setCivicAddress(String civicAddress) {
        this.civicAddress = civicAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PropertySpecification getPropertySpecification() {
        return propertySpecification;
    }

    public void setPropertySpecification(PropertySpecification propertySpecification) {
        this.propertySpecification = propertySpecification;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        // Notify subscribers only when property is available
        if (this.isOccupied != null && isOccupied == false) postMessage(this.address + " is available");

        this.isOccupied = isOccupied;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observers.contains(obj)) observers.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed) return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        for (Observer obj : observersLocal) {
            obj.update(this);
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    //method to post message to the topic
    public void postMessage(String msg) {
        System.out.println("Message Posted for Property: " + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Property {" +
                "ID=" + propertyId +
                ", civicAddress='" + civicAddress + '\'' +
                ", address=" + address +
                ", specs={" + propertySpecification +
                "} , rent=" + rentAmount +
                '}';
    }

    public Boolean getChanged() {
        return changed;
    }
}