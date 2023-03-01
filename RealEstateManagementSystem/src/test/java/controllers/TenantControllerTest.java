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

	@BeforeEach
	void setUp() {
		Tenant tenant;
		tenants = new ArrayList<>();
		String firstName = "John";
		String lastName = "Doe";
		String phoneNumber = "1234567890";
		String email = "johndoe@example.com";
		tenant = new Tenant(firstName, lastName, phoneNumber, email);
		Database.getInstance().addTenant(tenant);
		tenants.add(tenant);

		firstName = "Jane";
		lastName = "Doe";
		phoneNumber = "0987654321";
		email = "janedoe@example.com";
		tenant = new Tenant(firstName, lastName, phoneNumber, email);
		Database.getInstance().addTenant(tenant);
		tenants.add(tenant);
	}

	@AfterEach
	void tearDown() {
		tenants = null;
		Database.getInstance().setTenants(null);
	}

	@Test
	void testAddTenant() {
		List<Tenant> tenantsList = Database.getInstance().getTenants();
		assertTrue(!tenantsList.isEmpty());
	}

	/*
	 * Tests if properties are added successfully or not
	 */
	@Test
	void testDisplayTenants() {
		List<Tenant> tenantList = Database.getInstance().getTenants();
		assertEquals(tenants.size(), tenantList.size());
	}
}
