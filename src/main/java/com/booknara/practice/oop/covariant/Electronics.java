package com.booknara.practice.oop.covariant;

public class Electronics implements CustomCloneable {
    public final String product;

    public Electronics(String product) {
        this.product = product;
    }

    @Override
    public Electronics customClone() {
        return new Electronics(this.product);
    }

    public String getProduct() {
        return product;
    }
}
