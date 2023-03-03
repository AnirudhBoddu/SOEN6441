package test.java.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.models.Address;
import main.java.models.House;
import main.java.models.Property;
import main.java.models.PropertySpecification;
import main.java.services.HouseFactory;

public class HouseFactoryTest {

	private HouseFactory houseFactory;
	private Property property;
	private String civicAddress;
	private Address address;
	private PropertySpecification propertySpecification;
	private double rentAmount;

	@Before
	public void setUp() {
		houseFactory = new HouseFactory();
		civicAddress = "123 Main St.";
		address = new Address("123", "Main St.", "Toronto", "ON", "Canada");
		propertySpecification = new PropertySpecification(2, 2, 1650);
		rentAmount = 2000.0;

		property = houseFactory.createProperty(civicAddress, address, propertySpecification, null, rentAmount);
	}

	@After
	public void tearDown() {
		houseFactory = null;
	}

	@Test
	public void testCreateProperty() {
		assertTrue(property instanceof House);
		assertEquals(civicAddress, property.getCivicAddress());
		assertEquals(address, property.getAddress());
		assertEquals(propertySpecification, property.getPropertySpecification());
		assertEquals(rentAmount, property.getRentAmount(), 0.001);
	}

}
