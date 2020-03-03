package com.booknara.problem.sort;

import org.junit.Assert;
import org.junit.Test;

public class SingleNumberTest {
    @Test
    public void singleNumber() {
        SingleNumber singleNumber = new SingleNumber();

        Assert.assertEquals(1, singleNumber.singleNumber(new int[] {2,2,1}));
        Assert.assertEquals(4, singleNumber.singleNumber(new int[] {4,1,2,1,2}));
        Assert.assertEquals(1, singleNumber.singleNumber(new int[] {4,4,2,1,2}));
    }
}
