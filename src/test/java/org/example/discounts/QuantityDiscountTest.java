package org.example.discounts;

import org.example.Product;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class QuantityDiscountTest {

    @Test
    void ifQuantityIsLessThan5ApplyNoDiscount() {

        Product p = new Product("Gurka", 21, 4);

        double expected =  p.price() * p.quantity();

        double appliedDiscount = expected - new QuantityDiscount().apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }

    @Test
    void ifQuantityIsFiveApplyDiscount() {

        Product p = new Product("Tomat", 39, 5);

        double expected = p.price() * p.quantity() - (p.quantity() * 10); // 10 for every single item.

        double appliedDiscount = (p.price() * p.quantity()) - new QuantityDiscount().apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }
//
//    @Test
//    void applyTwoMilkDiscountsReturnDoubleTheDiscount() {
//        MilkDiscount milkDisc = new MilkDiscount();
//        MilkDiscount twoMilkDiscs = new MilkDiscount(milkDisc);
//
//        Product p = new Product("Milk", 21, 3);
//
//        double expected = p.price() * p.quantity() * 0.9; // 10% off (double discount)
//
//        double appliedDiscount = (p.price() * p.quantity()) - twoMilkDiscs.apply(p);
//
//        assertThat(appliedDiscount).isEqualTo(expected);
//    }
}