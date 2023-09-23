package org.example;

import org.example.Product;
import org.example.BaseDiscount;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class MilkDiscount extends BaseDiscount {

    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
        description = "Milk - 5% off";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.name().equalsIgnoreCase("Milk");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.05;
    }
}
