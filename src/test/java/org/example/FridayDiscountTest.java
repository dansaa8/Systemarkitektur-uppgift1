package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


class FridayDiscountTest {

    @Test
    void ifTodayIsNotFridayThenDiscountIsNotApplied() {

        FridayDiscount fridayDiscount = new FridayDiscount("Thursday");
        Product p = new Product("Tomatsöppa", 15, 3);

        double expected =  p.price() * p.quantity();

        double appliedDiscount = expected - fridayDiscount.apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }

    @Test
    void ifTodayIsFridayThenApplyDiscount() {

        Product p = new Product("Taco", 60, 5);

        double expected = p.price() * p.quantity() * 0.9;

        double appliedDiscount = (p.price() * p.quantity()) - new FridayDiscount("Friday").apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }
}