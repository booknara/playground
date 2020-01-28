package com.booknara.problem.array;

import org.junit.Assert;
import org.junit.Test;

public class HappyNumberTest {

    @Test
    public void isHappyTest() {
        HappyNumber happyNumber = new HappyNumber();

        Assert.assertTrue(happyNumber.isHappy(19));
        Assert.assertTrue(happyNumber.isHappy(7));
        Assert.assertFalse(happyNumber.isHappy(4));
        Assert.assertFalse(happyNumber.isHappy(116));
    }
}
