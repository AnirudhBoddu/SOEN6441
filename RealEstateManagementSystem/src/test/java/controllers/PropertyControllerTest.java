package test.java.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.java.Database;
import main.java.models.Address;
import main.java.models.Property;
import main.java.models.PropertySpecification;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;

class PropertyControllerTest {

	private PropertyFactory propertyFactory;
	private Address address;
	private PropertySpecification propertySpec;
	private Property property;
	private List<Property> properties;

	@Before
	public void setup() {
		// Adding one property
		propertyFactory = new HouseFactory();
		address = new Address("123 Main St", "Apt 1", "Anytown", "Anystate", "12345");
		propertySpec = new PropertySpecification(2, 1, 1500);
		property = propertyFactory.createProperty(null, address, propertySpec, null, 1350);

		// Adding multiple properties
		properties = new ArrayList<Property>();
		assertTrue(Database.getInstance().addProperty(property));
		properties.add(property);
		address = new Address("321 Oak St", "Apt 5", "Anytown", "Anystate", "67891");
		propertySpec = new PropertySpecification(1, 1, 1000);
		property = propertyFactory.createProperty(null, address, propertySpec, null, 1050);
		properties.add(property);
	}

	/*
	 * Tests if property is added successfully or not
	 */
	@Test
	void testAddProperty() {
		assertTrue(Database.getInstance().addProperty(property));
	}

	/*
	 * Tests if properties are added successfully or not
	 */
	@Test
	void testDisplayProperties() {
		List<Property> propertyList = Database.getInstance().getProperties();
		assertNotNull(propertyList);
	}

	@After
	public void tearDown() {
		propertyFactory = null;
		address = null;
		propertySpec = null;
		property = null;
		properties = null;
	}
}
