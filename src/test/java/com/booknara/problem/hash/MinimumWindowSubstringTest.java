package com.booknara.problem.hash;

import com.booknara.problem.twopointers.MinimumWindowSubstring;
import org.junit.Assert;
import org.junit.Test;

public class MinimumWindowSubstringTest {
    @Test
    public void minWindow() {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        Assert.assertEquals("BANC", minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        Assert.assertEquals("", minimumWindowSubstring.minWindow("A", "AAA"));
        Assert.assertEquals("AA", minimumWindowSubstring.minWindow("AA", "AA"));
    }
}
