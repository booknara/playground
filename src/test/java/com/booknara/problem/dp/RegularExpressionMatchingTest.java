package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class RegularExpressionMatchingTest {
    @Test
    public void isMatch() {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        Assert.assertTrue(regularExpressionMatching.isMatch("aa", "a*"));
    }
}
