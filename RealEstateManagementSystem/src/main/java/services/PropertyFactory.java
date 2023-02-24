package main.java.services;

import main.java.models.Address;
import main.java.models.Property;
import main.java.models.PropertySpecification;

public abstract class PropertyFactory {
    public abstract Property createProperty(String civicAddress, Address address, PropertySpecification propertySpecification, String unitNum, double rentAmount);
}






