package test.java.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Database;
import main.java.models.Tenant;

import static org.junit.jupiter.api.Assertions.*;

public class TenantTest {

	private Tenant tenant;
	private Database dbInstance = Database.getInstance();

	@BeforeEach
	public void setUp() {
		tenant = new Tenant("John", "Doe", "555-5555", "johndoe@example.com");
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

		assertEquals("555-5555", tenant.getPhoneNumber());
		tenant.setPhoneNumber("123-4567");
		assertEquals("123-4567", tenant.getPhoneNumber());

		assertEquals("johndoe@example.com", tenant.getEmail());
		tenant.setEmail("janesmith@example.com");
		assertEquals("janesmith@example.com", tenant.getEmail());
	}

	@Test
	public void testToString() {
		assertEquals(
				"Tenant{tenantId=2, firstName='John', lastName='Doe', phoneNumber='555-5555', email='johndoe@example.com'}",
				tenant.toString());
	}
}
