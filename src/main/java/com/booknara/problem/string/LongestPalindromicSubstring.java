package com.booknara.problem.string;

/**
 * 5. Longest Palindromic Substring (Medium)
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }

        int max = 1;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // case #1: aba (odd length palindrome)
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                if (max < r - l + 1) {
                    max = r - l + 1;
                    start = l;
                    end = r;
                }
                l--;
                r++;
            }
            // case #2: aa (even length palindrome)
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                if (max < r - l + 1) {
                    max = r - l + 1;
                    start = l;
                    end = r;
                }

                l--;
                r++;
            }
        }

        return s.substring(start, end + 1);
    }
}
