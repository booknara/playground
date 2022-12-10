package com.booknara.problem.twopointers;

/**
 * 424. Longest Repeating Character Replacement (Medium)
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class LongestRepeatingCharacterReplacement {
  // T:O(n), S:O(1)
  public int characterReplacement(String s, int k) {
    // edge case
    if (s.length() < 2 || s.length() <= k) {
      return s.length();
    }

    int l = 0, res = 0, max = 0;
    int[] bucket = new int[26]; // only uppercase letters
    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i);

      bucket[c - 'A']++;
      int len = i - l + 1;
      // max = getMax(bucket);
      max = Math.max(max, bucket[c - 'A']);
      System.out.println(max);
      if (len - max <= k) {
        res = Math.max (res, len);
      } else {
        bucket[s.charAt(l) - 'A']--;
        l++;
      }
    }

    return res;
  }

  public int getMax(int[] bucket) {
    int max = 0;
    for (int i = 0; i < bucket.length; i++) {
      max = Math.max(max, bucket[i]);
    }

    return max;
  }
}
