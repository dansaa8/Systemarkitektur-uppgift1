package org.example.discounts;

import org.example.Product;
import org.junit.jupiter.api.Test;
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

        double expected = p.price() * p.quantity() * 0.9; // 10% off

        double appliedDiscount = (p.price() * p.quantity()) - new FridayDiscount("Friday").apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }

    @Test
    void applyTwoFridayDiscountsReturnDoubleTheDiscount() {
        FridayDiscount friDisc = new FridayDiscount("Friday");
        FridayDiscount twoFriDiscs = new FridayDiscount("Friday", friDisc);

        Product p = new Product("Taco", 60, 5);

        double expected = p.price() * p.quantity() * 0.8; // 20% off (double discount)

        double appliedDiscount = (p.price() * p.quantity()) - twoFriDiscs.apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }
}