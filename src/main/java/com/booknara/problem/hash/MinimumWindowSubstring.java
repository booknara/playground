package com.booknara.problem.hash;

/**
 * Leet code : Minimum Window Substring(Hard)
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class MinimumWindowSubstring {
    // Time complexity: O(2S + N), Space complexity: O(S)
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        for (char c: t.toCharArray()) {
            map[c]++;
        }

        int required = t.length();
        int begin = 0;
        int l = 0, r = 0, len = Integer.MAX_VALUE;
        String res = "";
        while (r < s.length()) {
            char c = s.charAt(r);
            map[c]--;
            if (map[c] >= 0) required--;

            while(required == 0) {
                c = s.charAt(l);
                map[c]++;
                if (map[c] > 0) {
                    if (r - l + 1 < len) {
                        begin = l;
                        len = r - l + 1;
                        res = s.substring(begin, begin + len);
                    }
                    required++;
                }

                l++;
            }
            r++;
        }

        return res;
    }
}
