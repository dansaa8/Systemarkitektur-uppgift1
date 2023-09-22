package org.example;

import org.example.Product;
import org.example.BaseDiscount;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FridayDiscount extends BaseDiscount {

    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        String dayName = LocalDate.now().getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        return dayName.equals("Friday");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.9;
    }

    @Override
    public double apply(Product product) {
        return isApplicable(product) ?
                calculateDiscount(product) :
                product.price();
    }

    @Override
    public String getDescription(Product product) {
        return isApplicable(product) ?
                "Fredagsrabatt, " + nextDiscount.getDescription(product) :
                nextDiscount.getDescription(product);

    }
}
