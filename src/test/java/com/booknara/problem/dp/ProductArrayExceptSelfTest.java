package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ProductArrayExceptSelfTest {
    @Test
    public void coinChangeTest() {
        ProductArrayExceptSelf productArrayExceptSelf = new ProductArrayExceptSelf();
        Assert.assertArrayEquals(productArrayExceptSelf.productExceptSelf(new int[]{1,2}),
                new int[]{2,1});
        Assert.assertArrayEquals(productArrayExceptSelf.productExceptSelf(new int[]{1,2,3,4}),
                new int[]{24,12,8,6});

        int[] result = productArrayExceptSelf.optimizedProductExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(result));
        Assert.assertArrayEquals(result, new int[]{24,12,8,6});

//        Assert.assertArrayEquals(productArrayExceptSelf.optimizedProductExceptSelf(new int[]{1,2}),
//                new int[]{2,1});


    }
}
