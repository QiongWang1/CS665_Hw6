/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: DriverFactory.java
 * Description: Factory class for creating Driver objects.
 */
package edu.bu.met.cs665.hw;

public class DriverFactory {
    public static Driver createDriver(String name, int priority) {
        return new Driver(name, priority);
    }
}
