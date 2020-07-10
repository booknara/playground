package com.booknara.problem.dc;

/**
 * 395. Longest Substring with At Least K Repeating Characters (Medium)
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    // T:O(n^2), S:O(1)
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) return 0;

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int start = 0;
        boolean valid = true;
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            int c = count[s.charAt(end) - 'a'];
            if (c > 0 && c < k) {
                valid = false;
                max = Math.max(max, longestSubstring(s.substring(start, end), k));
                start = end + 1;
            }
        }

        // all the chracters or max or the rest string after for loop
        return valid ? s.length() : Math.max(max, longestSubstring(s.substring(start), k));
    }

    public int longestSubstring1(String s, int k) {
        if (s == null || s.length() < k) return 0;

        return divideAndConquer(0, s.length(), s, k);
    }

    public int divideAndConquer(int start, int end, String s, int k) {
        int[] count = new int[26];

        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            int c = count[s.charAt(i) - 'a'];

            if (c > 0 && c < k) {
                int l = divideAndConquer(start, i, s, k);
                int r = divideAndConquer(i + 1, end, s, k);
                return Math.max(l, r);
            }
        }

        return end - start;
    }
}
