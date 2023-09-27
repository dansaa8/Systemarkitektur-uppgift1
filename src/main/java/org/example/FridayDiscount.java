package org.example;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FridayDiscount extends BaseDiscount {
    String today;
    String description = "Friday - 10% off";

    public FridayDiscount(){today = Utils.getNameOfToday();}

    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
        today = Utils.getNameOfToday();
    }

    public FridayDiscount(String day) {today = day;} // used for testing

    public FridayDiscount(Discount nextDiscount, String day) { // used for testing.
        super(nextDiscount);
        today = day;
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
