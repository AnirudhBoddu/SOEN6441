package test.java.controllers;

import main.java.Database;
import main.java.models.Address;
import main.java.models.Property;
import main.java.models.PropertySpecification;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PropertyControllerTest {

    private PropertyFactory propertyFactory;
    private Address address;
    private PropertySpecification propertySpec;
    private List<Property> properties;
    private Database dbInstance = Database.getInstance();

    @BeforeEach
    public void setup() {
        dbInstance.clearData();
        Property property;
        properties = new ArrayList<>();
        propertyFactory = new HouseFactory();
        address = new Address(123, "Main St", "Anytown", "Anystate", "12345");
        propertySpec = new PropertySpecification(2, 1, 1500);
        property = propertyFactory.createProperty(null, address, propertySpec, null, 1350);
        dbInstance.addProperty(property);
        properties.add(property);

        /***
         Creating another property with different values using the same procedure as above
         and adding it to the ArrayList and database for further testing
         ***/

        address = new Address(321, "Oak St", "Anytown", "Anystate", "67891");
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

    /*
     * Runs after each test method.
     * Here we are setting the objects to null and empty the properties from the database to prevent duplicates and
     * ensure cleanliness between tests
     **/
    @AfterEach
    public void tearDown() {
        dbInstance.clearData();
    }
}
