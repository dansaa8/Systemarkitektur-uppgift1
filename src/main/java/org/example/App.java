package org.example;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Product myProduct = new Product("Milk", 500, 5);
        FridayDiscount combined = new FridayDiscount(new MilkDiscount(null));

        QuantityDiscount quantity = new QuantityDiscount(null);

//        System.out.println(combined.apply(myProduct) * myProduct.quantity());
//
//        System.out.println(combined.getDescription(myProduct));

        System.out.println(quantity.apply(myProduct) * myProduct.quantity());

    }
}
