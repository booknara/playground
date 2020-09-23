package com.booknara.problem.string;

import org.junit.Assert;
import org.junit.Test;

public class MinimumRemoveValidParenthesesTest {
    @Test
    public void minRemoveToMakeValid() {
        MinimumRemoveValidParentheses minimumRemoveValidParentheses = new MinimumRemoveValidParentheses();
        Assert.assertEquals("lee(t(c)o)de", minimumRemoveValidParentheses.minRemoveToMakeValid("lee(t(c)o)de)"));
        Assert.assertEquals("ab(c)d", minimumRemoveValidParentheses.minRemoveToMakeValid("a)b(c)d"));
        Assert.assertEquals("", minimumRemoveValidParentheses.minRemoveToMakeValid("))(("));
        Assert.assertTrue("(a(bc)d)".equals(minimumRemoveValidParentheses.minRemoveToMakeValid("(a(b(c)d)"))
        || "a(b(c)d)".equals(minimumRemoveValidParentheses.minRemoveToMakeValid("(a(b(c)d)")));
    }
}
