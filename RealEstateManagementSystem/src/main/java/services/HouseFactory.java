package main.java.services;

import main.java.models.House;
import main.java.models.Property;

public class HouseFactory extends PropertyFactory {
    @Override
    public Property createProperty() {
    	// TODO
        return new House(null, null, null);
    }
}
