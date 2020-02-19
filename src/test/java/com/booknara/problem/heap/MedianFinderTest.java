package com.booknara.problem.heap;

import org.junit.Assert;
import org.junit.Test;

public class MedianFinderTest {
    @Test
    public void medianFinder() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        Assert.assertEquals(1.5, medianFinder.findMedian(), 0);
        medianFinder.addNum(3);
        Assert.assertEquals(2.0, medianFinder.findMedian(), 0);
    }

    @Test
    public void medianFinder2() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        Assert.assertEquals(-1.0, medianFinder.findMedian(), 0);
        medianFinder.addNum(-2);
        Assert.assertEquals(-1.5, medianFinder.findMedian(), 0);
        medianFinder.addNum(-3);
        Assert.assertEquals(-2.0, medianFinder.findMedian(), 0);
    }
}
