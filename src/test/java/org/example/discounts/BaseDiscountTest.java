package org.example.discounts;

import org.example.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseDiscountTest {
    @Test
    void applyOnNullProductShouldReturnZero() {

        Product p = null;

        double expected =  0;

        double appliedDiscount = expected -
                new QuantityDiscount().apply(p) +
                new MilkDiscount().apply(p) +
                new FridayDiscount("Friday").apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }

    @Test
    void productWithSeveralDiscountsAppliedReturnCombinedDiscount() {
        var combinedDiscounts = new MilkDiscount(new QuantityDiscount(new FridayDiscount("Friday")));


        Product p = new Product("Milk", 19, 7);

        double productTotal =  p.price() * p.quantity();

        double expected =
                productTotal * 0.05 // <- milk
                               + 70 // <- quantity
                + productTotal * 0.10; // friday



        assertEquals(expected, combinedDiscounts.apply(p));
    }

    @Test
    void onlyReturnTheCorrectDescriptionWhenOneDiscountIsApplied() {
        Product milkProduct = new Product("Milk", 19, 4);
        var combined = new MilkDiscount(new FridayDiscount(new QuantityDiscount(), "Wednesday"));

        assertThat(combined.getDescription(milkProduct)).isEqualTo("Milk - 5% off");
    }

    @Test
    void onlyReturnTheCorrectDescriptionWhenTwoDiscountsAreApplied() {
        Product beerProduct = new Product("Beer", 19, 6);
        var combined = new MilkDiscount(new FridayDiscount(new QuantityDiscount(), "Friday"));
        System.out.println(combined.apply(beerProduct));

        assertThat(combined.getDescription(beerProduct))
                .isEqualTo("Friday - 10% off, " +
                        "Quantity - 10kr off each product, when buying more than 5 of a product");
    }

}