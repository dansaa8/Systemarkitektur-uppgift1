package org.example.discounts;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;
import org.example.Product;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomDiscountTest {

    @Test
    void createACustomBeerDiscountAndApplyItToAValidProduct() {
        Product beer = new Product("Beer", 25, 4);
        double beerTotal = beer.price() * beer.quantity();

        Predicate<Product> isApplicable = product -> product.name().equalsIgnoreCase("Beer");
        Function<Product, Double> calculateDiscount = product -> product.price() * product.quantity() * 0.15;
        CustomDiscount beerDiscount = new CustomDiscount("Beer - 15% off", isApplicable, calculateDiscount);

        double expectedDiscount = beerTotal * 0.15;

        assertThat(beerDiscount.apply(beer)).isEqualTo(expectedDiscount);
        assertThat(beerDiscount.getDescription(beer)).isEqualTo("Beer - 15% off");

    }

    @Test
    void createACustomBeerDiscountAndApplyItToAnInvalidProduct() {
        Product wine = new Product("Wine", 89, 2);
        double wineTotal = wine.price() * wine.quantity();

        Predicate<Product> isApplicable = product -> product.name().equalsIgnoreCase("Beer");
        Function<Product, Double> calculateDiscount = product -> product.price() * product.quantity() * 0.15;
        CustomDiscount beerDiscount = new CustomDiscount("Beer - 15% off", isApplicable, calculateDiscount);

        assertThat(beerDiscount.apply(wine)).isEqualTo(0);
        assertThat(beerDiscount.getDescription(wine)).isEqualTo("");
    }

    @Test
    void createTwoCustomDiscountsAndNestThemWithADefaultDiscount() {
        Product cola = new Product("Coca-Cola", 17, 8);
        double colaTotal = cola.price() * cola.quantity();

        // This discount should not be applied:
        Predicate<Product> isApplicableToBeerDiscount = product -> product.name().equalsIgnoreCase("Beer");
        Function<Product, Double> calculateBeerDiscount = product -> product.price() * product.quantity() * 0.15;


        var combinedDiscounts =
                new FridayDiscount("Friday",

                        new CustomDiscount(
                                "Beer - 15% off",
                                isApplicableToBeerDiscount,
                                calculateBeerDiscount,

                                createColaDiscount())
                );

        // Friday and colaDiscount applied:
        double expectedDiscount =
                colaTotal * 0.10 + 8;

        String expectedDescription =
                "Friday - 10% off, " + "Coca-Cola - 4kr rabatt vid köp av 3";

        assertThat(combinedDiscounts.apply(cola)).isEqualTo(expectedDiscount);
        assertThat(combinedDiscounts.getDescription(cola).equalsIgnoreCase(expectedDescription));

    }


    private CustomDiscount createColaDiscount() {
        // Coca-Cola rabatt, 4kr avdrag för varje köp av tre flaskor.
        // 5 flaskor ger 4kr rabatt.
        // 6 flaskor ger 8kr. rabatt osv...
        Predicate<Product> isApplicableToColaQuantityDiscount = product ->
                product.name().equalsIgnoreCase("Coca-Cola") &&
                        product.quantity() >= 3;

        Function<Product, Double> calculateColaDiscount = product -> {
            if(isApplicableToColaQuantityDiscount.test(product)) {
                int numberOfColas = (int) Math.floor(product.quantity()) / 3;
                double discountPerCollection = 4;
                return numberOfColas * discountPerCollection;
            } else {
                return 0.0;
            }};

        String colaDescription = "Coca-Cola - 4kr rabatt vid köp av 3";
        return new CustomDiscount(
                colaDescription,
                isApplicableToColaQuantityDiscount,
                calculateColaDiscount);
    }

}
