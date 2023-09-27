package org.example;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class App {
    public static void main(String[] args) {

//        FridayDiscount combined = new FridayDiscount(new MilkDiscount(null));
//
//        QuantityDiscount quantity = new QuantityDiscount(null);

//        System.out.println(combined.apply(myProduct) * myProduct.quantity());
//
//        System.out.println(combined.getDescription(myProduct));
        Product product = new Product("Taco", 60, 1);
       double totalPrice = (product.price() * 1) - new FridayDiscount("Friday").apply(product);
        System.out.println(totalPrice);

    }
}
