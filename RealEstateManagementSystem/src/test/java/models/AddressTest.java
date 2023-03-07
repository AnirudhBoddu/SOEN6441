package test.java.models;

import main.java.models.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AddressTest {
    private Address address;
    private Address address1;


    @BeforeEach
    public void setUp() {
        address = Mockito.mock(Address.class);
        address1 = new Address(1234, "Main St", "Vancouver", "BC", "V5V 2L3");
        Mockito.when(address.getStreetNumber()).thenReturn(1234);
        Mockito.when(address.getStreetName()).thenReturn("Main St");
        Mockito.when(address.getCity()).thenReturn("Vancouver");
        Mockito.when(address.getProvince()).thenReturn("BC");
        Mockito.when(address.getPostalCode()).thenReturn("V5V 2L3");
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
        address1.setStreetNumber(5678);
        address1.setStreetName("Oak St");
        address1.setCity("Burnaby");
        address1.setProvince("BC");
        address1.setPostalCode("V5G 3L4");

        Assertions.assertEquals(5678, address1.getStreetNumber());
        Assertions.assertEquals("Oak St", address1.getStreetName());
        Assertions.assertEquals("Burnaby", address1.getCity());
        Assertions.assertEquals("BC", address1.getProvince());
        Assertions.assertEquals("V5G 3L4", address1.getPostalCode());
    }


    @Test
    public void testToString() {
        String expected = "'1234 Main St, Vancouver, BC, V5V 2L3'";
        Assertions.assertEquals(expected, address1.toString());
    }
}
