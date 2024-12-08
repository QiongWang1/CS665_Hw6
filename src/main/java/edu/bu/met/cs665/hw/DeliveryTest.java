/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: DeliveryTest.java
 * Description: Test class for verifying the full implementation with patterns.
 */
package edu.bu.met.cs665.hw;

public class DeliveryTest {
    public static void main(String[] args) {
        // Create a shop
        Shop shop = new Shop("Shop A");

        // Set a notification strategy
        System.out.println("Setting strategy: BroadcastNotificationStrategy");
        shop.setStrategy(new BroadcastNotificationStrategy());

        // Create drivers with both name and priority
        Driver driver1 = new Driver("Driver 1", 1);
        Driver driver2 = new Driver("Driver 2", 2);
        Driver driver3 = new Driver("Driver 3", 3);

        // Register drivers as observers
        shop.addObserver(driver1);
        shop.addObserver(driver2);
        shop.addObserver(driver3);

        // Create a delivery request and notify drivers
        System.out.println("Creating delivery request: Delivering 'Books' to '123 Main St'");
        shop.createDeliveryRequest("Books", "123 Main St");

        // Change strategy to priority-based
        System.out.println("\nChanging strategy: PriorityNotificationStrategy");
        shop.setStrategy(new PriorityNotificationStrategy());
        System.out.println("Creating delivery request: Delivering 'Laptop' to '456 Park Ave'");
        shop.createDeliveryRequest("Laptop", "456 Park Ave");

        // Test case: No drivers registered
        Shop emptyShop = new Shop("Empty Shop");
        System.out.println("\nTesting with no drivers registered:");
        emptyShop.createDeliveryRequest("Tablet", "789 Elm St");
    }
}
