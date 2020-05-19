package com.booknara.problem.stack;

import org.junit.Assert;
import org.junit.Test;

public class StockSpannerTest {
    @Test
    public void test() {
        StockSpanner stockSpanner = new StockSpanner();
        Assert.assertEquals(1, stockSpanner.next(28));
        Assert.assertEquals(1, stockSpanner.next(14));
        Assert.assertEquals(3, stockSpanner.next(28));
        Assert.assertEquals(4, stockSpanner.next(35));
        Assert.assertEquals(5, stockSpanner.next(46));
        Assert.assertEquals(6, stockSpanner.next(53));
        Assert.assertEquals(7, stockSpanner.next(66));
        Assert.assertEquals(8, stockSpanner.next(80));
        Assert.assertEquals(9, stockSpanner.next(87));
        Assert.assertEquals(10, stockSpanner.next(88));
    }
}
