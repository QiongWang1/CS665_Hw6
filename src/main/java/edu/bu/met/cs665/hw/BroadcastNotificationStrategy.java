/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: BroadcastNotificationStrategy.java
 * Description: Notification strategy for broadcasting to all drivers.
 */
package edu.bu.met.cs665.hw;

import java.util.List;

public class BroadcastNotificationStrategy implements NotificationStrategy {
    @Override
    public void notifyDrivers(List<Driver> drivers, DeliveryRequest request) {
        for (Driver driver : drivers) {
            driver.notify(request);
        }
    }
}
