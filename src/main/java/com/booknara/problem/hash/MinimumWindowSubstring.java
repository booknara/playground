package com.booknara.problem.hash;

/**
 * 76. Minimum Window Substring (Hard)
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    // Time complexity: O(n), Space complexity: O(1)
    public String minWindow(String s, String t) {
        // input check
        if (s.length() == 0 || t.length() == 0) return "";

        int[] bucket = new int[128];
        for (char c: t.toCharArray()) {
            bucket[c]++;
        }
        // [2,1,1] = "AABC"
        // two pointers
        int l = 0, r = 0;
        int len = t.length();       // required the total number of string contained
        int min = Integer.MAX_VALUE;
        String res = "";
        while (r < s.length()) {
            char c = s.charAt(r);
            bucket[c]--;
            if (bucket[c] >= 0) {
                len--;
            }

            // "ADOBECODEAB"
            while (len == 0) {
                char d = s.charAt(l);
                bucket[d]++;
                if (bucket[d] > 0) {
                    len++;
                }

                // (r, l)
                if (r - l + 1 < min) {
                    res = s.substring(l, r + 1);
                    min = r - l + 1;
                }

                l++;
            }

            r++;
        }

        return res;
    }
}
