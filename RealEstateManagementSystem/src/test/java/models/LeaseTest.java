package test.java.models;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import main.java.models.Address;
import main.java.models.House;
import main.java.models.Lease;
import main.java.models.Property;
import main.java.models.PropertySpecification;
import main.java.models.Tenant;

public class LeaseTest {

	private Tenant tenant;
	private Property property;
	private Lease lease;

	@Before
	public void setUp() {
		Address address = new Address("123", "Main St", "AnyCity", "NS", "12345");
		PropertySpecification propertySpec = new PropertySpecification(2, 1, 1350);
		property = new House(null, address, propertySpec, 2000);
		tenant = new Tenant("John", "Doe", "johndoe@gmail.com", "123-456-7890");
		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime() + (1000 * 60 * 60 * 24 * 365)); // One year from startDate
		lease = new Lease(tenant, property, 2000.0, startDate, endDate);
	}

	@Test
	public void testGetTenant() {
		assertEquals(tenant, lease.getTenant());
	}

	@Test
	public void testGetLeaseId() {
		assertTrue(lease.getLeaseId() > 0);
	}

	@Test
	public void testGetProperty() {
		assertEquals(property, lease.getProperty());
	}

	@Test
	public void testGetRentAmount() {
		assertEquals(2000.0, lease.getRentAmount(), 0.001);
	}

	@Test
	public void testSetRentAmount() {
		lease.setRentAmount(2300.0);
		assertEquals(2300.0, lease.getRentAmount(), 0.001);
	}

	@Test
	public void testGetStartDate() {
		assertNotNull(lease.getStartDate());
	}

	@Test
	public void testSetStartDate() {
		Date newStartDate = new Date();
		lease.setStartDate(newStartDate);
		assertEquals(newStartDate, lease.getStartDate());
	}

	@Test
	public void testGetEndDate() {
		assertNotNull(lease.getEndDate());
	}

	@Test
	public void testSetEndDate() {
		Date newEndDate = new Date();
		lease.setEndDate(newEndDate);
		assertEquals(newEndDate, lease.getEndDate());
	}

	@Test
	public void testGetActive() {
		assertFalse(lease.getActive());
	}

	@Test
	public void testSetActive() {
		lease.setActive(true);
		assertTrue(lease.getActive());
	}

	@Test
	public void testIsPaid() {
		assertFalse(lease.isPaid());
	}

	@Test
	public void testSetIsPaid() {
		lease.setIsPaid(true);
		assertTrue(lease.isPaid());
	}

	@Test
	public void testToString() {
		String expected = "Lease{leaseId=" + lease.getLeaseId() + ", tenant=" + tenant + ", property=" + property
				+ ", rentAmount=" + lease.getRentAmount() + ", startDate=" + lease.getStartDate() + ", endDate="
				+ lease.getEndDate() + ", isActive=false}";
		assertEquals(expected, lease.toString());
	}

}
