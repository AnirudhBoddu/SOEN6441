package test.java.models;

import main.java.Database;
import main.java.models.Tenant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TenantTest {

    private Tenant tenant;
    private Database dbInstance = Database.getInstance();

    @BeforeEach
    public void setUp() {
        tenant = new Tenant("John", "Doe", "johndoe@example.com", 5555555);
        dbInstance.getTenants().clear();
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("John", tenant.getFirstName());
        tenant.setFirstName("Jane");
        assertEquals("Jane", tenant.getFirstName());

        assertEquals("Doe", tenant.getLastName());
        tenant.setLastName("Smith");
        assertEquals("Smith", tenant.getLastName());

        assertEquals(5555555, tenant.getPhoneNumber());
        tenant.setPhoneNumber(1234567);
        assertEquals(1234567, tenant.getPhoneNumber());

        assertEquals("johndoe@example.com", tenant.getEmail());
        tenant.setEmail("janesmith@example.com");
        assertEquals("janesmith@example.com", tenant.getEmail());
    }

    @Test
    public void testToString() {
        String expected = "Tenant{tenantId=" + tenant.getTenantId() + ", firstName='" + tenant.getFirstName() + "', lastName='" + tenant.getLastName()
                + "', phoneNumber='" + tenant.getPhoneNumber() + "', email='" + tenant.getEmail() + "'}";
        assertEquals(expected, tenant.toString());
    }
}
