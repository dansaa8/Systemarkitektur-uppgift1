package org.example.discounts;

import org.example.Product;
import org.example.Utils;

public class FridayDiscount extends BaseDiscount {
    String today;
    String description = "Friday - 10% off";

    public FridayDiscount(){today = Utils.getNameOfToday();}

    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
        today = Utils.getNameOfToday();
    }

    public FridayDiscount(String day) {
        today = day;
    } // used for testing

    public FridayDiscount(Discount nextDiscount, String day) {
        super(nextDiscount);
        today = day;
    }// used for testing.

    @Override
    protected boolean isApplicable(Product product) {
        return today.equals("Friday");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * product.quantity() * 0.10;
    }
}
