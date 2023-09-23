package org.example;

import org.example.Product;
import org.example.BaseDiscount;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FridayDiscount extends BaseDiscount {

    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
        description = "Friday - 10% off";
    }

    @Override
    protected boolean isApplicable(Product product) {
        String dayName = LocalDate.now().getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        return dayName.equals("Saturday");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.10;
    }
}
