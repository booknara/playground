package com.booknara.problem.string;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTest {
    @Test
    public void longestPalindromeTest() {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        Assert.assertEquals("bab", longestPalindromicSubstring.longestPalindrome("babad"));
    }
}
