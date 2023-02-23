package main.java.services;

import main.java.models.Apartment;
import main.java.models.Property;

public class ApartmentFactory extends PropertyFactory {
	@Override
	public Property createProperty() {
		// TODO
		return new Apartment(null, null, null, null);
	}
}
