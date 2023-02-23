package main.java.services;

import main.java.models.Address;
import main.java.models.Condo;
import main.java.models.Property;
import main.java.models.PropertySpecification;

public class CondoFactory extends PropertyFactory {
    @Override
    public Property createProperty(String civicAddress, Address address, PropertySpecification propertySpecification, String unitNum) {
        return new Condo(civicAddress, address, propertySpecification, unitNum);
    }
}
