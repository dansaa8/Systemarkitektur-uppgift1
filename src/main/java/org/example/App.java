package org.example;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Product myProduct = new Product("Airplane", 500, 2);
        FridayDiscount fridayDiscount = new FridayDiscount(null);


        System.out.println(myProduct.name());
        System.out.println(myProduct.price());
        System.out.println(fridayDiscount.getDescription(myProduct));


    }
}
