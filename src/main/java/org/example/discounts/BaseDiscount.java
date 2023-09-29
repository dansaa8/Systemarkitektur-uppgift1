package org.example.discounts;

import org.example.Product;

public abstract class BaseDiscount implements Discount {
    Discount nextDiscount;
    String description;
    public BaseDiscount() {nextDiscount = null;}
    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    @Override
    public double apply(Product product) {
        if (product == null) return 0;

        if (nextDiscount != null)
            return isApplicable(product) ?
                    calculateDiscount(product) + nextDiscount.apply(product) :
                    nextDiscount.apply(product);

        return isApplicable(product) ?
                calculateDiscount(product) :
                0;
    }

    @Override
    public String getDescription(Product product) {
        StringBuilder result = new StringBuilder();

        if (isApplicable(product)) {
            result.append(this.description);

            if (nextDiscount != null) {
                String nextDescription = nextDiscount.getDescription(product);
                if (!nextDescription.isEmpty()) {
                    result.append(", ");
                    result.append(nextDescription);
                }
            }
        } else if (nextDiscount != null) {
            return nextDiscount.getDescription(product);
        }

        return result.toString();

    }


    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);
}
