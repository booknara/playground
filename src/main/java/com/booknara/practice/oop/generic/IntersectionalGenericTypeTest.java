package com.booknara.practice.oop.generic;

import com.booknara.practice.oop.covariant.Electronics;

public class IntersectionalGenericTypeTest {
    public static void main(String[] args) {
        Electronics originalProduct = new Electronics("Mobile Phone");

        Electronics clonedProduct = originalProduct.customClone();
        System.out.println(clonedProduct.getProduct());

//        Object clonedProduct = originalProduct.customClone();
//        System.out.println(clonedProduct.getProduct()); // Compile ERROR: getProduct() is not a method of Object
    }
}
