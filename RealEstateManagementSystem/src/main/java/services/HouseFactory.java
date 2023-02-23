package main.java.services;

import main.java.models.Address;
import main.java.models.House;
import main.java.models.Property;
import main.java.models.PropertySpecification;

public class HouseFactory extends PropertyFactory {
    @Override
    public Property createProperty(String civicAddress, Address address, PropertySpecification propertySpecification,
    String apartmentNumber) {
    	// TODO
        return new House(civicAddress, address, propertySpecification);
    }
}
