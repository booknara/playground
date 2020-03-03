package com.booknara.problem.greedy;

import org.junit.Assert;
import org.junit.Test;

public class LemonadeChangeTest {
    @Test
    public void lemonadeChange() {
        LemonadeChange lemonadeChange = new LemonadeChange();
        Assert.assertTrue(lemonadeChange.lemonadeChange(new int[]{5,5,5,10,20}));
        Assert.assertTrue(lemonadeChange.lemonadeChange(new int[]{5,5,10}));
        Assert.assertFalse(lemonadeChange.lemonadeChange(new int[]{10,10}));
        Assert.assertFalse(lemonadeChange.lemonadeChange(new int[]{5,5,10,10,20}));

        Assert.assertTrue(lemonadeChange.lemonadeChangeSimple(new int[]{5,5,5,10,20}));
        Assert.assertTrue(lemonadeChange.lemonadeChangeSimple(new int[]{5,5,10}));
        Assert.assertFalse(lemonadeChange.lemonadeChangeSimple(new int[]{10,10}));
        Assert.assertFalse(lemonadeChange.lemonadeChangeSimple(new int[]{5,5,10,10,20}));
    }
}
