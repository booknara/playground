package com.booknara.problem.twopointers;

/**
 * 3. Longest Substring Without Repeating Characters (Medium)
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // T:O(n), S:O(1)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int m = s.length();
        int[] bucket = new int[128];  // input range is all ascii characters
        int l = 0, r = 0;
        int max = 1;
        while (r < m) {
            char c = s.charAt(r);
            bucket[c]++;

            if (bucket[c] >= 2) {
                // repeated
                while (l < r && bucket[c] > 1) {    // check bucket[c]
                    bucket[s.charAt(l)]--;
                    l++;
                }
            }

            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }

    // T:O(n), S:O(1)
    public int lengthOfLongestSubstring1(String s) {
        // input check
        if (s == null || s.length() == 0) return 0;

        int[] bucket = new int[128];
        int l = 0, r = 0;
        int max = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            bucket[c]++;
            if (bucket[c] > 1) {
                while (l < r) {
                    char d = s.charAt(l);
                    bucket[d]--;
                    l++;
                    if (d == c) {
                        break;
                    }
                }
            }

            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}
