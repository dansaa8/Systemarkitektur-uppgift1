package org.example;

public abstract class BaseDiscount implements Discount {
    Discount nextDiscount;
    String description;
    public BaseDiscount() {nextDiscount = null;}
    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    @Override
    public double apply(Product product) {

        if (nextDiscount != null)
            return isApplicable(product) ?
                    nextDiscount.apply(product) - calculateDiscount(product) :
                    0;

        return isApplicable(product) ?
                product.price() - calculateDiscount(product) :
                0;
    }

    @Override
    public String getDescription(Product product) {
        if (nextDiscount != null)
            return isApplicable(product) ?
                    this.description + ",\n" + nextDiscount.getDescription(product) :
                    nextDiscount.getDescription(product);

        return isApplicable(product) ?
                this.description :
                "";
    }

    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);
}
