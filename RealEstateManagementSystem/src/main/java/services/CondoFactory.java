package main.java.services;

import main.java.models.Condo;
import main.java.models.Property;

public class CondoFactory extends PropertyFactory {
    @Override
    public Property createProperty() {
    	// TODO
        return new Condo(null, null, null, null);
    }
}
