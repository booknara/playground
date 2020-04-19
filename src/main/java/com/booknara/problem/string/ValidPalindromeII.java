package com.booknara.problem.string;

/**
 * 680. Valid Palindrome II (Easy)
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }

        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                // exclude one left character or exclude one right character
                return dfs(s.substring(l + 1, r + 1))
                        || dfs(s.substring(l, r));
            }
        }

        return true;
    }

    private boolean dfs(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }

        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }
}
