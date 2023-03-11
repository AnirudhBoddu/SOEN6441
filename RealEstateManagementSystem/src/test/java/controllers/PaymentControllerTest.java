package test.java.controllers;

import main.java.Database;
import main.java.controllers.LeaseController;
import main.java.controllers.PaymentController;
import main.java.models.*;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentControllerTest {

    private PropertyFactory propertyFactory;
    private Address address;
    private PropertySpecification propertySpec;
    private Database dbInstance = Database.getInstance();
    private Lease newLease;

    @BeforeEach
    void setUp() {

        // Creating Property
        Property property;
        propertyFactory = new HouseFactory();
        address = new Address(123, "Main St", "Anytown", "Anystate", "12345");
        propertySpec = new PropertySpecification(2, 1, 1500);
        property = propertyFactory.createProperty(null, address, propertySpec, null, 1350);
        dbInstance.addProperty(property);

        // Creating Tenant

        Tenant tenant;

        String firstName = "John";
        String lastName = "Doe";
        String phoneNumber = "1234567890";
        String email = "johndoe@example.com";
        tenant = new Tenant(firstName, lastName, email, phoneNumber);
        dbInstance.addTenant(tenant);

        Property p = dbInstance.getProperties().get(0);
        Tenant t = dbInstance.getTenants().get(0);

        newLease = new Lease(t, p,
                p.getRentAmount(), LocalDate.of(2020,1,1),
                LocalDate.of(2026,1,1));

        dbInstance.addLease(newLease);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInstance() {
        // Testing Class Getter
        assertNotNull(PaymentController.getInstance());
    }

    @Test
    void createNewPayment() {

        //Lease lease, double amount, Tenant tenant, Date dueDate, Date paidOn
        String simulatedUserInput = "1" + System.getProperty("\n") +
                "1" + System.getProperty("line.separator") +
                "1000" + System.getProperty("line.separator") +
                "1" + System.getProperty("line.separator");

        Calendar sys = Calendar.getInstance();
        dbInstance.addPayment(new Payment(newLease,1000,dbInstance.getTenants().get(0),sys.getTime(),sys.getTime()));

        Payment payment = dbInstance.getPayments().get(0);

        assertEquals(payment.getAmount(),1000);

    }
}