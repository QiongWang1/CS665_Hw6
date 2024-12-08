/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: DeliveryRequestFactory.java
 * Description: Factory class for creating DeliveryRequest objects.
 */
package edu.bu.met.cs665.hw;

public class DeliveryRequestFactory {
    public static DeliveryRequest createRequest(String product, String destination) {
        return new DeliveryRequest(product, destination);
    }
}
