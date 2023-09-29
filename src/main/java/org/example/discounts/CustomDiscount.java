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
        nextDiscount = null;
        this.description = description;
        this.isApplicableFunction = isApplicableFunction;
        this.calculateDiscountFunction = calculateDiscountFunction;
    }

    public CustomDiscount(Discount nextDiscount,
                          String description,
                          Predicate<Product> isApplicableFunction,
                          Function<Product, Double> calculateDiscountFunction
    ) {
        this.nextDiscount = nextDiscount;
        this.description = description;
        this.isApplicableFunction = isApplicableFunction;
        this.calculateDiscountFunction = calculateDiscountFunction;
    }

    protected boolean isApplicable(Product product) {
        return isApplicableFunction.test(product);
    }

    @Override
    protected double calculateDiscount(Product product) {
        return calculateDiscountFunction.apply(product);
    }
}
