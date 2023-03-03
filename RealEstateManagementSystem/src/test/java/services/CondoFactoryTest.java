package test.java.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.models.Address;
import main.java.models.Condo;
import main.java.models.Property;
import main.java.models.PropertySpecification;
import main.java.services.CondoFactory;

public class CondoFactoryTest {

	private Address address;
	private PropertySpecification propertySpecification;
	private Property property;

	@Before
	public void setUp() {
		CondoFactory condoFactory = new CondoFactory();
		address = new Address("321", "Queen St.", "Montreal", "QC", "H3X2V2");
		propertySpecification = new PropertySpecification(4, 2, 3000);
		String civicAddress = "321 Queen St.";
		String unitNum = "Unit 1";
		double rent = 4000.00;
		property = condoFactory.createProperty(civicAddress, address, propertySpecification, unitNum, rent);
	}

	@After
	public void tearDown() {
		property = null;
		propertySpecification = null;
		address = null;
	}

	@Test
	public void testCreateProperty() {
		assertEquals("321 Queen St.", property.getCivicAddress());
		assertEquals(address, property.getAddress());
		assertEquals(propertySpecification, property.getPropertySpecification());
		assertEquals("Unit 1", ((Condo) property).getUnitNumber());
		assertEquals(4000.00, property.getRentAmount(), 0.0);
		assertTrue(property instanceof Condo);
	}

}
