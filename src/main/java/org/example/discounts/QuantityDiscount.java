package org.example.discounts;

import org.example.Product;

public class QuantityDiscount extends BaseDiscount {


    public QuantityDiscount(){super();
       description = "Quantity - 10kr off each product, when buying more than 5 of a product";
    }

    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
        description = "Quantity - 10kr off each product, when buying more than 5 of a product";
    }


    @Override
    protected boolean isApplicable(Product product) {
        return (product.quantity() >= 5);
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 10 * product.quantity();
    }
}
