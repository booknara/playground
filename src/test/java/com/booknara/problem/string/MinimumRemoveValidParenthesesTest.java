package com.booknara.problem.string;

import org.junit.Assert;
import org.junit.Test;

public class MinimumRemoveValidParenthesesTest {
    @Test
    public void minRemoveToMakeValid() {
        MinimumRemoveValidParentheses minimumRemoveValidParentheses = new MinimumRemoveValidParentheses();
        Assert.assertEquals("lee(t(c)o)de", minimumRemoveValidParentheses.minRemoveToMakeValidBetter("lee(t(c)o)de)"));
        Assert.assertEquals("ab(c)d", minimumRemoveValidParentheses.minRemoveToMakeValidBetter("a)b(c)d"));
        Assert.assertEquals("", minimumRemoveValidParentheses.minRemoveToMakeValidBetter("))(("));
        Assert.assertTrue("(a(bc)d)".equals(minimumRemoveValidParentheses.minRemoveToMakeValidBetter("(a(b(c)d)"))
        || "a(b(c)d)".equals(minimumRemoveValidParentheses.minRemoveToMakeValidBetter("(a(b(c)d)")));
    }
}
