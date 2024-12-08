/**
 * Name: Qiong Wang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: ShopTest.java
 * Description: Test class for Shop functionality.
 */
package edu.bu.met.cs665.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class ShopTest {  // 改为default访问级别，删除public关键字
    private Shop shop;
    private Driver driver1;
    private Driver driver2;
    private Driver driver3;

    @BeforeEach
    void setUp() {  // 改为default访问级别，删除public关键字
        shop = new Shop("Shop A");
        driver1 = DriverFactory.createDriver("Driver 1", 1);
        driver2 = DriverFactory.createDriver("Driver 2", 2);
        driver3 = DriverFactory.createDriver("Driver 3", 3);
    }

    @Test
    @DisplayName("Test adding observers to shop")
    void testAddObserver() {  // 改为default访问级别，删除public关键字
        shop.addObserver(driver1);
        shop.addObserver(driver2);
        List<Driver> expectedDrivers = new ArrayList<>();
        expectedDrivers.add(driver1);
        expectedDrivers.add(driver2);
        assertEquals(expectedDrivers, shop.getDrivers());
    }

    @Test
    @DisplayName("Test removing observers from shop")
    void testRemoveObserver() {  // 改为default访问级别，删除public关键字
        shop.addObserver(driver1);
        shop.addObserver(driver2);
        shop.removeObserver(driver1);
        assertFalse(shop.getDrivers().contains(driver1));
    }

    @Test
    @DisplayName("Test broadcast notification strategy")
    void testBroadcastNotification() {  // 改为default访问级别，删除public关键字
        shop.addObserver(driver1);
        shop.addObserver(driver2);
        shop.addObserver(driver3);
        shop.setStrategy(new BroadcastNotificationStrategy());
        DeliveryRequest request = DeliveryRequestFactory.createRequest("Books", "123 Main St");

        shop.notifyObservers(request);
        assertTrue(shop.getObservers().contains(driver1));
        assertTrue(shop.getObservers().contains(driver2));
        assertTrue(shop.getObservers().contains(driver3));
    }

    @Test
    @DisplayName("Test priority-based notification strategy")
    void testPriorityNotification() {  // 改为default访问级别，删除public关键字
        shop.addObserver(driver1);
        shop.addObserver(driver2);
        shop.addObserver(driver3);
        shop.setStrategy(new PriorityNotificationStrategy());
        DeliveryRequest request = DeliveryRequestFactory.createRequest("Laptop", "456 Park Ave");

        shop.notifyObservers(request);
        assertTrue(shop.getObservers().size() > 0);
        assertEquals(1, driver1.getPriority());
    }
}