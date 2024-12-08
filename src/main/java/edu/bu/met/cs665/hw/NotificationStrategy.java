/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: NotificationStrategy.java
 * Description: Strategy interface for different driver notification methods.
 */
package edu.bu.met.cs665.hw;

import java.util.List;

public interface NotificationStrategy {
    void notifyDrivers(List<Driver> drivers, DeliveryRequest request);
}
