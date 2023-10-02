package org.example.discounts;

import org.example.Product;
import org.example.Utils;

public class FridayDiscount extends BaseDiscount {
    String today;

    public FridayDiscount() {
        this(Utils.getNameOfToday());
    }

    public FridayDiscount(String day) { // used for testing
        this(day, null);
    }

    public FridayDiscount(Discount nextDiscount) {
        this(Utils.getNameOfToday(), nextDiscount);
    }

    public FridayDiscount(String day, Discount nextDiscount) { // used for testing
        super(nextDiscount);
        today = day;
        description = "Friday - 10% off";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return today.equals("Friday");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * product.quantity() * 0.10;
    }
}