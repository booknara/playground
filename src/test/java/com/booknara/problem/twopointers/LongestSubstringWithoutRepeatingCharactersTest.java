package com.booknara.problem.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    public void lengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters
                = new LongestSubstringWithoutRepeatingCharacters();

        Assert.assertEquals(3, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(5, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwawkes"));
        Assert.assertEquals(2, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abba"));
    }
}
