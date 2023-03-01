package test.java.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Database;
import main.java.models.Tenant;

class TenantControllerTest {
	private List<Tenant> tenants;
	private Database dbInstance = Database.getInstance();

	@BeforeEach
	void setUp() {
		Tenant tenant;
		tenants = new ArrayList<>();
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567890";
		String email = "johndoe@example.com";
		tenant = new Tenant(firstName, lastName, phoneNumber, email);
		dbInstance.addTenant(tenant);
		tenants.add(tenant);

		firstName = "Jane";
		lastName = "Doe";
		phoneNumber = "0987654321";
		email = "janedoe@example.com";
		tenant = new Tenant(firstName, lastName, phoneNumber, email);
		dbInstance.addTenant(tenant);
		tenants.add(tenant);
	}

	@AfterEach
	void tearDown() {
		tenants = null;
		dbInstance.getTenants().clear();
	}

	@Test
	void testAddTenant() {
		List<Tenant> tenantsList = dbInstance.getTenants();
		assertTrue(tenantsList.size() == 2);
		assertEquals(tenants.get(0).getTenantId(), tenantsList.get(0).getTenantId());
		assertEquals(tenants.get(1).getTenantId(), tenantsList.get(1).getTenantId());
	}

	/*
	 * Tests if properties are added successfully or not
	 */
	@Test
	void testDisplayTenants() {
		List<Tenant> tenantList = dbInstance.getTenants();
		assertEquals(tenants.size(), tenantList.size());
	}
}
