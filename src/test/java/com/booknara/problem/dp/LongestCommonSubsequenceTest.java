package com.booknara.problem.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubsequenceTest {
    @Test
    public void longestCommonSubsequenceTest() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        Assert.assertEquals(lcs.longestCommonSubsequence("abcde", "ace"), 3);
        Assert.assertEquals(lcs.longestCommonSubsequence("abc", "abc"), 3);
        Assert.assertEquals(lcs.longestCommonSubsequence("abc", "def"), 0);
        Assert.assertEquals(lcs.longestCommonSubsequence("sea", "eat"), 2);

        Assert.assertEquals(lcs.longestCommonSubsequence1("abcde", "ace"), 3);
        Assert.assertEquals(lcs.longestCommonSubsequence1("abc", "abc"), 3);
        Assert.assertEquals(lcs.longestCommonSubsequence1("abc", "def"), 0);
    }
}
