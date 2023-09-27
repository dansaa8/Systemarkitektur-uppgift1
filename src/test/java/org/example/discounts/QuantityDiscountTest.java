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

    @Test
    void ifQuantityIsMoreThanFiveApplyDiscount() {

        Product p = new Product("Ramlösa", 14, 9);

        double expected = p.price() * p.quantity() - (p.quantity() * 10); // 10 for every single item.

        double appliedDiscount = (p.price() * p.quantity()) - new QuantityDiscount().apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }

    @Test
    void applyTwoQuantityDiscountsReturnDoubleTheDiscount() {
        QuantityDiscount quantityDisc = new QuantityDiscount();
        QuantityDiscount twoQuantityDiscs = new QuantityDiscount(quantityDisc);
        Product p = new Product("Coca cola", 19, 9);

        double expected = p.price() * p.quantity() - (p.quantity() * 20); // 20 for every single item (doubled).

        double appliedDiscount = (p.price() * p.quantity()) - twoQuantityDiscs.apply(p);

        assertThat(appliedDiscount).isEqualTo(expected);
    }
}