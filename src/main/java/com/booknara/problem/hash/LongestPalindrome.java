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

        int res = 0;
        boolean odd = false;
        for (int n: bucket) {
            if (n == 0) continue;

            if (n % 2 == 0) {
                // even
                res += n;
            } else {
                // odd (e.g. "acccddd")
                res += (n - 1);
                odd = true;
            }
        }

        if (odd) res++;

        return res;
    }
}
