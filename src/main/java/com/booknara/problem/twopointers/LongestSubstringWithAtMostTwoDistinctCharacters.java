package com.booknara.problem.twopointers;

/**
 * 159. Longest Substring with At Most Two Distinct Characters (Medium)
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;

        int max = 0;
        int distinct = 0;
        int l = 0, r = 0;
        int[] bucket = new int[256];
        while (r < s.length()) {
            char c = s.charAt(r);
            if (bucket[c] == 0) {
                // new character
                if (distinct == 2) {
                    // remove the existing character
                    while (distinct >= 2) {
                        bucket[s.charAt(l)]--;
                        if (bucket[s.charAt(l)] == 0) {
                            distinct--;
                        }
                        l++;
                    }
                }

                distinct++;
            }

            bucket[c]++;

            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}
