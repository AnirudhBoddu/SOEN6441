package test.java.controllers;

import main.java.Database;
import main.java.models.*;
import main.java.services.HouseFactory;
import main.java.services.PropertyFactory;
import org.junit.jupiter.api.*;

import main.java.controllers.LeaseController;
import static org.junit.jupiter.api.Assertions.*;

import javax.xml.crypto.Data;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class LeaseControllerTest {

    private PropertyFactory propertyFactory;
    private Address address;
    private PropertySpecification propertySpec;
    private Database dbInstance = Database.getInstance();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Lease newLease;

    @BeforeEach
    void setUp() {

        Property property;
        propertyFactory = new HouseFactory();
        address = new Address(123, "Main St", "Anytown", "Anystate", "12345");
        propertySpec = new PropertySpecification(2, 1, 1500);
        property = propertyFactory.createProperty(null, address, propertySpec, null, 1350);
        dbInstance.addProperty(property);


        /***
         Creating another property with different values using the same procedure as above
         and adding it to the ArrayList and database for further testing
         ***/

        address = new Address(321, "Oak St", "Anytown", "Anystate", "67891");
        propertySpec = new PropertySpecification(1, 1, 1000);
        property = propertyFactory.createProperty(null, address, propertySpec, null, 1050);
        dbInstance.addProperty(property);

        // Adding Tenants

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

    // System.setOut will catch the system out printed and put into the variable (typeOut).
    // The reason we take System.out is that we need to have it to check the correct response from the program is printed
    @AfterEach
    void tearDown() {
        dbInstance.clearData();

    }

    @Test
    void getInstance() {
        // Testing Class Getter
        assertNotNull(LeaseController.getInstance());

    }

    @Test
    void rentUnit() {

        dbInstance.addLease(newLease);

        Lease leaseInDb = dbInstance.getLeases().get(0);
        assertEquals(leaseInDb,newLease);

    }

    @Test
    void displayRentedUnits() {



        String simulatedUserInput = "7" + System.getProperty("line.separator");

        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        System.setOut(new PrintStream(outputStreamCaptor));
        LeaseController.getInstance().displayRentedUnits();
        assertEquals("Rented Units:\n" +
                "null - '123 Main St, Anytown, Anystate, 12345'", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void displayVacantUnits() {

        String simulatedUserInput = "8" + System.getProperty("line.separator");

        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        System.setOut(new PrintStream(outputStreamCaptor));
        LeaseController.getInstance().displayVacantUnits();

        assertEquals("Vacant Properties:\n" +
                "null - '123 Main St, Anytown, Anystate, 12345'\n" +
                "null - '321 Oak St, Anytown, Anystate, 67891'", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void displayAllLeases() {

        String simulatedUserInput = "9" + System.getProperty("line.separator");

        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        System.setOut(new PrintStream(outputStreamCaptor));
        LeaseController.getInstance().displayAllLeases();

        assertEquals("All Leases:\n" +
                "Lease {ID=7, tenant=Tenant {ID=13, firstName='John', lastName='Doe', phoneNumber='1234567890', email='johndoe@example.com'}, property=Property {ID=19, civicAddress='null', address='123 Main St, Anytown, Anystate, 12345', specs={numBedrooms=2, numBathrooms=1, squareFootage=1500} , rent=1350.0}, rentAmount=1350.0, startDate=2020-01-01, endDate=2026-01-01}", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void displayUnpaidLeases() {
        String simulatedUserInput = "10" + System.getProperty("line.separator");

        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        System.setOut(new PrintStream(outputStreamCaptor));
        LeaseController.getInstance().displayUnpaidLeases();

        assertEquals("Unpaid Leases:\n" +
                "Lease {ID=9, tenant=Tenant {ID=15, firstName='John', lastName='Doe', phoneNumber='1234567890', email='johndoe@example.com'}, property=Property {ID=23, civicAddress='null', address='123 Main St, Anytown, Anystate, 12345', specs={numBedrooms=2, numBathrooms=1, squareFootage=1500} , rent=1350.0}, rentAmount=1350.0, startDate=2020-01-01, endDate=2026-01-01}", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void terminateLeaseById() {
        String simulatedUserInput = "12" + System.getProperty("line.separator") + "9" + System.getProperty("line.separator");

        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        System.setOut(new PrintStream(outputStreamCaptor));
        LeaseController.getInstance().terminateLeaseById();

        assertNull(dbInstance.getLeaseById(9));
    }
}