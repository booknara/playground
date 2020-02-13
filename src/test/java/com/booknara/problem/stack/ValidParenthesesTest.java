package com.booknara.problem.stack;

import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesesTest {
    @Test
    public void isValid() {
        ValidParentheses validParentheses = new ValidParentheses();
        Assert.assertTrue(validParentheses.isValid("()"));
        Assert.assertFalse(validParentheses.isValid("(}"));
        Assert.assertTrue(validParentheses.isValid("()[]{}"));
        Assert.assertTrue(validParentheses.isValid("{[]}"));
    }
}
