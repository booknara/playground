package com.booknara.problem.stack;

import org.junit.Assert;
import org.junit.Test;

public class LongestValidParenthesesTest {
    @Test
    public void longestValidParentheses() {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        Assert.assertEquals(4, longestValidParentheses.longestValidParentheses(")()())"));
        Assert.assertEquals(2, longestValidParentheses.longestValidParentheses("(()"));
    }
}
