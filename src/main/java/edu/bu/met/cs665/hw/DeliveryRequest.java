/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: DeliveryRequest.java
 * Description: Class representing a delivery request containing product and destination.
 */
package edu.bu.met.cs665.hw;

public class DeliveryRequest {
    private String product;
    private String destination;

    public DeliveryRequest(String product, String destination) {
        this.product = product;
        this.destination = destination;
    }

    public String getProduct() {
        return product;
    }

    public String getDestination() {
        return destination;
    }
}
