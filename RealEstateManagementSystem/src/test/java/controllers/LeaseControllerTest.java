package java.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.controllers.LeaseController;

import static org.junit.jupiter.api.Assertions.*;

class LeaseControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInstance() {
        // Testing Class Getter
        Assertions.assertNotNull(LeaseController.getInstance());

        // Testing Singleton
        Assertions.assertSame(LeaseController.getInstance(), LeaseController.getInstance());
    }

    @Test
    void rentUnit() {
    }

    @Test
    void displayRentedUnits() {
    }

    @Test
    void displayVacantUnits() {
    }

    @Test
    void displayAllLeases() {
    }

    @Test
    void displayUnpaidLeases() {
    }

    @Test
    void terminateLeaseById() {
    }
}