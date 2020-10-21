package com.booknara.problem.twopointers;

/**
 * 76. Minimum Window Substring (Hard)
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    // Time complexity: O(n), Space complexity: O(1)
    public String minWindow(String s, String t) {
        // input check
        if (t.length() == 0) return s;
        if (s.length() == 0) return "";
        if (s.length() < t.length()) return "";

        // bucketing t (A~Z, a~z)
        int[] bucket = new int[128];
        for (char c: t.toCharArray()) {
            bucket[c]++;
        }

        String res = "";
        int min = Integer.MAX_VALUE;
        int len = t.length();          // required the total number of string contained
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            bucket[c]--;
            if (bucket[c] >= 0) len--;  // Note: '>='

            while (l <= r && len == 0) {    // l <= r, edge case S:"a", T:"a"
                int size = r - l + 1;
                if (size < min) {
                    min = size;
                    res = s.substring(l, r + 1);
                }

                char d = s.charAt(l);
                bucket[d]++;
                if (bucket[d] > 0) {
                    len++;
                }
                l++;
            }

            r++;
        }

        return res;
    }
}
/**         01234567890
 Input: S = "ZADOBECODEABANC", T = "AABC"
 Output: "ABANC"

 T -> A:2, B:1, C:1
 bucket = [2,1,1,0,0,0,0,], the number of alphabet = 3;
 if (bucket[s.charAt(i)] >= 0) alphabet--
 if (alphabet == 0) {
 // get the sliding size
 }
 */