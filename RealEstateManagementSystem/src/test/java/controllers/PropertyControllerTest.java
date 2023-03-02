package test.java.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
	private List<Property> properties;
	private Database dbInstance = Database.getInstance();

	@BeforeEach
	public void setup() {
		Property property;
		properties =  new ArrayList<>();
		propertyFactory = new HouseFactory();
		address = new Address("123 Main St", "Apt 1", "Anytown", "Anystate", "12345");
		propertySpec = new PropertySpecification(2, 1, 1500);
		property = propertyFactory.createProperty(null, address, propertySpec, null, 1350);
		dbInstance.addProperty(property);
		properties.add(property);

		address = new Address("321 Oak St", "Apt 5", "Anytown", "Anystate", "67891");
		propertySpec = new PropertySpecification(1, 1, 1000);
		property = propertyFactory.createProperty(null, address, propertySpec, null, 1050);
		dbInstance.addProperty(property);
		properties.add(property);

	}

	/*
	 * Tests if property is added successfully or not
	 */
	@Test
	void testAddProperty() {
		List<Property> propertyList = dbInstance.getProperties();
		assertTrue(propertyList.size() == 2);
		assertEquals(properties.get(0).getPropertyId(), propertyList.get(0).getPropertyId());
		assertEquals(properties.get(1).getPropertyId(), propertyList.get(1).getPropertyId());
	}

	/*
	 * Tests if all the properties are added successfully or not
	 */
	@Test
	void testDisplayProperties() {
		List<Property> propertyList = dbInstance.getProperties();
		assertEquals(properties.size(), propertyList.size());
	}

	@AfterEach
	public void tearDown() {
		propertyFactory = null;
		address = null;
		propertySpec = null;
		properties = null;
		dbInstance.getProperties().clear();
	}
}
