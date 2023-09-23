package org.example;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Product myProduct = new Product("Milk", 500, 2);
        FridayDiscount combined = new FridayDiscount(new MilkDiscount(null));


        System.out.println(combined.apply(myProduct));

        System.out.println(combined.getDescription(myProduct));

        System.out.println();

    }
}
