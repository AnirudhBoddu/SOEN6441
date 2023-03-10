package test.java.models;

import main.java.models.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressTest {
    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address(1234, "Main St", "Vancouver", "BC", "V5V 2L3");
    }

    @Test
    public void testGetters() {
        Assertions.assertEquals(1234, address.getStreetNumber());
        Assertions.assertEquals("Main St", address.getStreetName());
        Assertions.assertEquals("Vancouver", address.getCity());
        Assertions.assertEquals("BC", address.getProvince());
        Assertions.assertEquals("V5V 2L3", address.getPostalCode());
    }

    @Test
    public void testSetters() {
        address.setStreetNumber(5678);
        address.setStreetName("Oak St");
        address.setCity("Burnaby");
        address.setProvince("BC");
        address.setPostalCode("V5G 3L4");

        Assertions.assertEquals(5678, address.getStreetNumber());
        Assertions.assertEquals("Oak St", address.getStreetName());
        Assertions.assertEquals("Burnaby", address.getCity());
        Assertions.assertEquals("BC", address.getProvince());
        Assertions.assertEquals("V5G 3L4", address.getPostalCode());
    }

    @Test
    public void testToString() {
        String expected = "'1234 Main St, Vancouver, BC, V5V 2L3'";
        Assertions.assertEquals(expected, address.toString());
    }
}
