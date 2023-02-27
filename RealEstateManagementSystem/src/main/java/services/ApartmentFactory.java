package main.java.services;

import main.java.models.Address;
import main.java.models.Apartment;
import main.java.models.Property;
import main.java.models.PropertySpecification;

public class ApartmentFactory extends PropertyFactory {
	@Override
	public Property createProperty(String civicAddress, Address address, PropertySpecification propertySpecification,
	String apartmentNumber, double rentAmount) {
		return new Apartment(civicAddress, address, propertySpecification, apartmentNumber, rentAmount);
	}
}
