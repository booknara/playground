package com.booknara.problem.string;

/**
 * 680. Valid Palindrome II (Easy)
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {
    // T:O(n), S:O(1)
    public boolean validPalindrome(String s) {
        // input check, non-empty string
        if (s.length() <= 2) return true;

        // "abc"
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                // skip l or r
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }

        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
