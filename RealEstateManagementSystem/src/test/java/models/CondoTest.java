package test.java.models;

import main.java.models.Address;
import main.java.models.Condo;
import main.java.models.PropertySpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CondoTest {

    private Condo condo;

    @BeforeEach
    public void setUp() {
        Address address = new Address(1234, "Main St", "Vancouver", "BC", "V6B 2T4");
        PropertySpecification propertySpec = new PropertySpecification(2, 2, 800);
        condo = new Condo("1234 Main St, Vancouver, BC, V6B 2T4", address, propertySpec, "Unit 101", 2000.00);
    }

    @Test
    public void testGetUnitNumber() {
        assertEquals("Unit 101", condo.getUnitNumber());
    }

    @Test
    public void testSetUnitNumber() {
        condo.setUnitNumber("Unit 102");
        assertEquals("Unit 102", condo.getUnitNumber());
    }

    @Test
    public void testToString() {
        String expected = "Property {ID="+condo.getPropertyId()+", civicAddress='1234 Main St, Vancouver, BC, V6B 2T4', address='1234 Main St, Vancouver, BC, V6B 2T4', specs={numBedrooms=2, numBathrooms=2, squareFootage=800} , rent=2000.0}";
        assertEquals(expected, condo.toString());
    }
}
