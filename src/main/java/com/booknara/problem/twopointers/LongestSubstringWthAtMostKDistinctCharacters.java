package com.booknara.problem.twopointers;

/**
 * 340. Longest Substring with At Most K Distinct Characters (Hard)
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 */
public class LongestSubstringWthAtMostKDistinctCharacters {
    // T:O(n*k), S:O(1)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (k == 0) return 0;
        if (s.length() <= k) return s.length();

        int max = 1;
        int[] bucket = new int[128];
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);

            if (bucket[c] == 0) {
                bucket[c]++;
                k--;
                while (l < r && k < 0) {
                    char d = s.charAt(l);
                    bucket[d]--;     // move l pointer bucket[l]--
                    if (bucket[d] == 0) {
                        k++;
                    }
                    l++;
                }
            } else {
                bucket[c]++;
            }
            max = Math.max(max, r - l + 1);

            r++;
        }

        return max;
    }
}
/**
 Input: s = "ec eba", k = 2
 Output: 3
 e -> 1, k = 1

 c -> 0, k = 0
 e -> 0, k = 0

 b -> 1, k = -1, k = 0
 a -> 1, k = -1
 Method Two pointers
 bucket[]
 if (bucket[c] == 0) -> means new character. k--
    bucket[c]++;
    k--;
    while (l < r && k < 0)
        move l pointer bucket[l]--
        if (bucket[l] == 0) {
        k++;
    }
 else
    bucket[c]++;

 int max = Math.max(max, r - l + 1);
 */