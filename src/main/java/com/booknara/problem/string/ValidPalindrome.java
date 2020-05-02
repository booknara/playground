package com.booknara.problem.string;

/**
 * 125. Valid Palindrome (Easy)
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int l = 0, r = s.length() - 1;
        while (l < r) {
            // check and skip non-alphanumeric on the left side
            while (l < r && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(l)))) {
                l++;
            }

            // check and skip non-alphanumeric on the right side
            while (l < r && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(r)))) {
                r--;
            }

            if (l > r) {
                return true;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
