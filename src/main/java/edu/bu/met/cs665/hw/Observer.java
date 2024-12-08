/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: Observer.java
 * Description: Observer interface for receiving notifications about delivery requests.
 */
package edu.bu.met.cs665.hw;

public interface Observer {
    void notify(DeliveryRequest request);
}
