package com.booknara.problem.twopointers;

/**
 * 340. Longest Substring with At Most K Distinct Characters (Hard)
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 */
public class LongestSubstringWthAtMostKDistinctCharacters {
    // T:O(n*k), S:O(1)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int[] bucket = new int[256];
        int l = 0, r = 0;
        int distinct = 0;
        int max = 0;
        while (r < s.length()) {
            if (bucket[s.charAt(r)] == 0) distinct++;
            bucket[s.charAt(r)]++;

            while (distinct > k) {
                bucket[s.charAt(l)]--;
                if (bucket[s.charAt(l)] == 0) distinct--;
                l++;
            }

            // the longest length is the range of two pointers
            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}
