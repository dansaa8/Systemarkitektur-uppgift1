package org.example;

public class QuantityDiscount extends BaseDiscount {

    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
        description = "Quantity - 10kr off each product, when buying more than 5 of a product.";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.quantity() >= 5;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() - (10 * product.quantity());
    }
}
