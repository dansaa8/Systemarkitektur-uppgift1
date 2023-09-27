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
                new QuantityDiscount().apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }

}