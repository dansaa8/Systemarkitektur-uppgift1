package org.example;

import org.example.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testConstructorAndGetters() {
        // Create a Product instance
        Product product = new Product("Widget", 10.99, 5);

        // Test getters
        assertEquals("Widget", product.name());
        assertEquals(10.99, product.price());
        assertEquals(5, product.quantity());
    }

    @Test
    public void testEqualsAndHashCode() {
        Product product1 = new Product("Widget", 10.99, 5);
        Product product2 = new Product("Widget", 10.99, 5);
        Product product3 = new Product("Gadget", 15.99, 3);

        // Test equals method
        assertEquals(product1, product2);
        assertNotEquals(product1, product3);

        // Test hashCode
        assertEquals(product1.hashCode(), product2.hashCode());
        assertNotEquals(product1.hashCode(), product3.hashCode());
    }

    @Test
    public void testToString() {
        Product product = new Product("Widget", 10.99, 5);

        // Test toString method
        assertEquals("Product[name=Widget, price=10.99, quantity=5]", product.toString());
    }
}