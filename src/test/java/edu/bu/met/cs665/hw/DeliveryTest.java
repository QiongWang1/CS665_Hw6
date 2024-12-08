/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: DeliveryTest.java
 * Description: Test class for verifying the full implementation with patterns.
 */
package edu.bu.met.cs665.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryTest {
    private Shop shop;
    private Shop emptyShop;
    private Driver driver1;
    private Driver driver2;
    private Driver driver3;

    @BeforeEach
    void setUp() {
        // Initialize shops
        shop = new Shop("Shop A");
        emptyShop = new Shop("Empty Shop");

        // Initialize drivers with priorities
        driver1 = new Driver("Driver 1", 1);
        driver2 = new Driver("Driver 2", 2);
        driver3 = new Driver("Driver 3", 3);
    }

    @Test
    @DisplayName("Test broadcast notification strategy")
    void testBroadcastNotificationStrategy() {
        // Set up broadcast strategy
        shop.setStrategy(new BroadcastNotificationStrategy());

        // Register drivers
        shop.addObserver(driver1);
        shop.addObserver(driver2);
        shop.addObserver(driver3);

        // Create and verify delivery request
        shop.createDeliveryRequest("Books", "123 Main St");

        // Add assertions here to verify the behavior
        assertTrue(shop.getObservers().contains(driver1));
        assertTrue(shop.getObservers().contains(driver2));
        assertTrue(shop.getObservers().contains(driver3));
    }

    @Test
    @DisplayName("Test priority notification strategy")
    void testPriorityNotificationStrategy() {
        // Set up priority strategy
        shop.setStrategy(new PriorityNotificationStrategy());

        // Register drivers
        shop.addObserver(driver1);
        shop.addObserver(driver2);
        shop.addObserver(driver3);

        // Create and verify delivery request
        shop.createDeliveryRequest("Laptop", "456 Park Ave");

        // Add assertions to verify priority-based notification
        assertEquals(1, driver1.getPriority());
        assertTrue(driver1.getPriority() < driver2.getPriority());
    }

    @Test
    @DisplayName("Test empty shop scenario")
    void testEmptyShop() {
        // Verify empty shop behavior
        assertNotNull(emptyShop);
        assertTrue(emptyShop.getObservers().isEmpty());

        // Test delivery request with no drivers
        emptyShop.createDeliveryRequest("Tablet", "789 Elm St");
        assertEquals(0, emptyShop.getObservers().size());
    }

    @Test
    @DisplayName("Test driver registration and removal")
    void testDriverManagement() {
        // Test adding drivers
        shop.addObserver(driver1);
        assertTrue(shop.getObservers().contains(driver1));

        // Test removing drivers
        shop.removeObserver(driver1);
        assertFalse(shop.getObservers().contains(driver1));
    }

    @Test
    @DisplayName("Test strategy change")
    void testStrategyChange() {
        // Test strategy switching
        NotificationStrategy broadcastStrategy = new BroadcastNotificationStrategy();
        NotificationStrategy priorityStrategy = new PriorityNotificationStrategy();

        shop.setStrategy(broadcastStrategy);
        shop.setStrategy(priorityStrategy);

        // Verify that strategy can be changed without issues
        assertNotNull(shop.getStrategy());
    }
}