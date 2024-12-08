/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: PriorityNotificationStrategy.java
 * Description: Notification strategy for notifying the highest priority driver.
 */
package edu.bu.met.cs665.hw;

import java.util.List;

public class PriorityNotificationStrategy implements NotificationStrategy {
    @Override
    public void notifyDrivers(List<Driver> drivers, DeliveryRequest request) {
        Driver highestPriorityDriver = drivers.stream()
                .max((d1, d2) -> Integer.compare(d1.getPriority(), d2.getPriority()))
                .orElse(null);

        if (highestPriorityDriver != null) {
            highestPriorityDriver.notify(request);
        }
    }
}
