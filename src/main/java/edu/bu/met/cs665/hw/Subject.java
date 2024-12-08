/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: Subject.java
 * Description: Subject interface for managing observers in the Observer pattern.
 */
package edu.bu.met.cs665.hw;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(DeliveryRequest request);
}
