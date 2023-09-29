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
    }

    @Test
    void createACustomBeerDiscountAndApplyItToAnInvalidProduct() {
        Product wine = new Product("Wine", 89, 2);
        double wineTotal = wine.price() * wine.quantity();

        Predicate<Product> isApplicable = product -> product.name().equalsIgnoreCase("Beer");
        Function<Product, Double> calculateDiscount = product -> product.price() * product.quantity() * 0.15;
        CustomDiscount beerDiscount = new CustomDiscount("Beer - 15% off", isApplicable, calculateDiscount);

        assertThat(beerDiscount.apply(wine)).isEqualTo(0);
    }
}
