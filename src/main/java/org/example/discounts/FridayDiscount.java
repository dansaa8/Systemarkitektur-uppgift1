package org.example.discounts;

import org.example.Product;
import org.example.Utils;

public class FridayDiscount extends BaseDiscount {
    String today;
    public FridayDiscount(){
        today = Utils.getNameOfToday();
        description = "Friday - 10% off";
    }

    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
        today = Utils.getNameOfToday();
        description = "Friday - 10% off";
    }

    public FridayDiscount(String day) {
        today = day;
        description = "Friday - 10% off";
    } // used for testing

    public FridayDiscount(String day, Discount nextDiscount) {
        super(nextDiscount);
        today = day;
        description = "Friday - 10% off";
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
