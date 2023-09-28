package org.example.discounts;

import org.example.Product;

public class MilkDiscount extends BaseDiscount {

    public MilkDiscount(){
        description = "Milk - 5% off";
    }


    public MilkDiscount(Discount nextDiscount) {

        super(nextDiscount);
        description = "Milk - 5% off";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.name().equalsIgnoreCase("Milk");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * product.quantity() * 0.05;
    }
}
