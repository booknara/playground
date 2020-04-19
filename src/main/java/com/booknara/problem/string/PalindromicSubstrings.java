package com.booknara.problem.string;

/**
 * 647. Palindromic Substrings (Medium)
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += findAllPalindrome(s, i, i);     // odd
            res += findAllPalindrome(s, i, i + 1); // even
        }

        return res;
    }

    private int findAllPalindrome(String s, int i, int j) {
        int count = 0;
        // System.out.println(i);
        // System.out.println(j);
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            // extend <-- i, j -->
            i--;
            j++;
        }
        return count;
    }
}
