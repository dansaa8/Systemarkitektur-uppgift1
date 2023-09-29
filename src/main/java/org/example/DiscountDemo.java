package org.example;

import org.example.discounts.FridayDiscount;
import org.example.discounts.MilkDiscount;
import org.example.discounts.QuantityDiscount;

public class DiscountDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Cheese", 40, 3);
        Product p2 = new Product("Milk", 20, 5);
        Product p3 = new Product("Beer", 17, 6);

        var discount = new FridayDiscount("Friday");
        var combined1 = new MilkDiscount(new FridayDiscount("Wednesday", new QuantityDiscount()));
        var combined2 = new QuantityDiscount(new FridayDiscount("Monday"));

        System.out.println("Discounts for cheese: " + discount.apply(p1));
        System.out.println("Discounts for milk: " + combined1.apply(p2));
        System.out.println("Discounts for beer: " + combined2.apply(p3));

        System.out.println("Discounts for cheese: " + discount.getDescription(p1));
        System.out.println("Discounts for milk: " + combined1.getDescription(p2));
        System.out.println("Discounts for beer: " + combined2.getDescription(p3));
    }
}
