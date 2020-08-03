package com.booknara.problem.string;

/**
 * 680. Valid Palindrome II (Easy)
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {
    // T:O(n), S:O(1)
    public boolean validPalindrome(String s) {
        // input check, non-empty string s
        int l = 0, r = s.length() - 1;
        int graceTime = 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                // exclude one left character or exclude one right character
                return isPalindrome(s.substring(l, r))
                        || isPalindrome(s.substring(l + 1, r + 1));
            }
            l++;
            r--;
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
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
