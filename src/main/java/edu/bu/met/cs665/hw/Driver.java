/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: Driver.java
 * Description: Driver class implementing the Observer interface to receive notifications.
 */
package edu.bu.met.cs665.hw;

public class Driver implements Observer {
    private String name;
    private int priority;

    public Driver(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public void notify(DeliveryRequest request) {
        System.out.println("Driver " + name + " received request to deliver " +
                request.getProduct() + " to " + request.getDestination());
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}
