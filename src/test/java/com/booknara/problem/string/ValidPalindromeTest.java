package com.booknara.problem.string;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindromeTest {
    @Test
    public void isPalindrome() {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        Assert.assertTrue(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(validPalindrome.isPalindrome("race a car"));
    }
}
