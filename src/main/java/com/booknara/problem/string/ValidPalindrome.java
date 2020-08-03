package com.booknara.problem.string;

/**
 * 125. Valid Palindrome (Easy)
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    // T:O(n), S:O(1)
    public boolean isPalindrome(String s) {
        // input check
        if (s == null || s.length() == 0) {
            return true;
        }

        int l = 0, r = s.length() - 1;
        while (l < r) {
            // skip empty string or non-alphanumeric characters
            while (l < r) {
                if (Character.isLetterOrDigit(s.charAt(l))) break;
                l++;
            }
            while (l < r) {
                if (Character.isLetterOrDigit(s.charAt(r))) break;
                r--;
            }

            if (l == r) return true;

            if (Character.toLowerCase(s.charAt(l))
                    != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
