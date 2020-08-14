package com.booknara.problem.hash;

/**
 * 409. Longest Palindrome (Easy)
 * https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome {
    // T:O(n), S:O(1)
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] bucket = new int[128];
        for (char c: s.toCharArray()) {
            bucket[c]++;
        }

        boolean odd = false;
        int res = 0;
        for (int i: bucket) {
            if (i == 0) continue;

            if ((i & 1) == 1) {
                // e.g. ccc
                res += (i - 1);
                odd = true;
            } else {
                // e.g. aa
                res += i;
            }
        }

        // e.g. aabbb -> 2 + 2 + 1(odd)
        return odd ? res + 1 : res;
    }
}
