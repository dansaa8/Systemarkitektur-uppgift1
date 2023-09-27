package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


class MilkDiscountTest {

    @Test
    void ifProdNameIsNotMilkThenDiscountIsNotApplied() {

        Product p = new Product("Bärs", 12, 5);

        double expected =  p.price() * p.quantity();

        double appliedDiscount = expected - new MilkDiscount().apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }

    @Test
    void ifProdNameIsMilkThenApplyDiscount() {

        Product p = new Product("Milk", 21, 7);

        double expected = p.price() * p.quantity() * 0.95; // 5% off

        double appliedDiscount = (p.price() * p.quantity()) - new MilkDiscount().apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }

    @Test
    void applyTwoMilkDiscountsReturnDoubleTheDiscount() {
        MilkDiscount milkDisc = new MilkDiscount();
        MilkDiscount twoMilkDiscs = new MilkDiscount(milkDisc);

        Product p = new Product("Milk", 21, 3);

        double expected = p.price() * p.quantity() * 0.9; // 10% off (double discount)

        double appliedDiscount = (p.price() * p.quantity()) - twoMilkDiscs.apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }
}