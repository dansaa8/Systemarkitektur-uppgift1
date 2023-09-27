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

        double expectedTotal =  p.price() * p.quantity();
        System.out.println(fridayDiscount.apply(p));
        double appliedDiscount = expectedTotal - fridayDiscount.apply(p);

        assertThat(appliedDiscount).isEqualTo(expectedTotal);
    }
}