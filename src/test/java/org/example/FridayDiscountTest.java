package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


class FridayDiscountTest {

    @Test
    void ifTodayIsNotFridayThenDiscountIsNotApplied() {

        Product p = new Product("Tomatsöppa", 15, 3);

        double expected =  p.price() * p.quantity();

        double appliedDiscount = expected - new FridayDiscount("Thursday").apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }

    @Test
    void ifTodayIsFridayThenApplyDiscount() {

        Product p = new Product("Taco", 60, 5);

        double expected = p.price() * p.quantity() * 0.9;

        double appliedDiscount = (p.price() * p.quantity()) - new FridayDiscount("Friday").apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }

    @Test
    void applyTwoDiscountsReturnDoubleTheDiscount() {
        FridayDiscount friDisc = new FridayDiscount("Friday");
        FridayDiscount twoFriDiscs = new FridayDiscount(friDisc, "Friday");

        Product p = new Product("Taco", 60, 5);

        double expected = p.price() * p.quantity() * 0.8;

        double appliedDiscount = (p.price() * p.quantity()) - twoFriDiscs.apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }
}