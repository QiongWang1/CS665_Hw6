/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: Shop.java
 * Description: Shop class implementing Subject role with dynamic notification strategies.
 */
package edu.bu.met.cs665.hw;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Subject {
    private String name;
    private List<Driver> drivers = new ArrayList<>();
    private NotificationStrategy strategy;

    /**
     * Constructor for Shop.
     *
     * @param name Shop name
     */
    public Shop(String name) {
        this.name = name;
        this.strategy = new BroadcastNotificationStrategy(); // Default strategy
    }

    /**
     * Gets the name of the shop.
     *
     * @return Shop name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of observers (drivers).
     *
     * @return List of observers/drivers
     */
    public List<Driver> getObservers() {
        return this.drivers;
    }

    /**
     * Gets the list of drivers.
     *
     * @return List of drivers
     */
    public List<Driver> getDrivers() {
        return this.drivers;
    }

    /**
     * Gets the current notification strategy.
     *
     * @return Current notification strategy
     */
    public NotificationStrategy getStrategy() {
        return this.strategy;
    }

    /**
     * Sets the notification strategy.
     *
     * @param strategy New notification strategy
     */
    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer instanceof Driver && !drivers.contains(observer)) {
            drivers.add((Driver) observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        drivers.remove(observer);
    }

    @Override
    public void notifyObservers(DeliveryRequest request) {
        if (drivers.isEmpty()) {
            System.out.println("No drivers available for delivery.");
            return;
        }
        if (strategy != null) {
            strategy.notifyDrivers(drivers, request);
        }
    }

    /**
     * Creates a new delivery request and notifies relevant drivers.
     *
     * @param product     Product to be delivered
     * @param destination Delivery destination
     */
    public void createDeliveryRequest(String product, String destination) {
        DeliveryRequest request = DeliveryRequestFactory.createRequest(product, destination);
        notifyObservers(request);
    }
}