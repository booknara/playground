package com.booknara.problem.array;

import org.junit.Assert;
import org.junit.Test;

public class HitCounterTest {
    @Test
    public void test() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        Assert.assertEquals(3, hitCounter.getHits(4));

        hitCounter.hit(300);
        Assert.assertEquals(4, hitCounter.getHits(300));
        Assert.assertEquals(3, hitCounter.getHits(301));
    }
}
