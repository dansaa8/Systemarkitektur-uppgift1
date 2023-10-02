package org.example.discounts;

import org.example.Product;

import java.util.function.Function;
import java.util.function.Predicate;

public class CustomDiscount extends BaseDiscount {
    private final Predicate<Product> isApplicableFunction;
    private final Function<Product, Double> calculateDiscountFunction;
    public CustomDiscount(
            String description,
            Predicate<Product> isApplicableFunction,
            Function<Product, Double> calculateDiscountFunction
    ) {
        this(description, isApplicableFunction, calculateDiscountFunction, null);
    }

    public CustomDiscount(
            String description,
            Predicate<Product> isApplicableFunction,
            Function<Product, Double> calculateDiscountFunction,
            Discount nextDiscount
    ) {
        this.description = description;
        this.isApplicableFunction = isApplicableFunction;
        this.calculateDiscountFunction = calculateDiscountFunction;
        this.nextDiscount = nextDiscount;
    }

    protected boolean isApplicable(Product product) {
        return isApplicableFunction.test(product);
    }

    @Override
    protected double calculateDiscount(Product product) {
        return calculateDiscountFunction.apply(product);
    }
}
