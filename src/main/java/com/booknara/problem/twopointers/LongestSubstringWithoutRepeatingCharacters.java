package com.booknara.problem.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters (Medium)
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
  // T:O(n), S:O(1)
  public int lengthOfLongestSubstring(String s) {
    // input check
    if (s == null || s.length() == 0) return 0;

    Map<Character, Integer> map = new HashMap<>();
    int res = 0;
    int l = 0;
    // "abcdefgg"
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      // exist
      if (map.containsKey(c) && l <= map.get(c)) {
        // jump to the last appearance index
        l = map.get(c) + 1;
      }
      map.put(c, i);
      res = Math.max(res, i - l + 1);
    }

    return res;
  }

  // T:O(n), S:O(1)
  public int lengthOfLongestSubstring1(String s) {
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
  public int lengthOfLongestSubstring2(String s) {
    // input check
    if (s == null || s.length() == 0) return 0;
    if (s.length() == 1) return 1;

    int l = 0, r = 0;
    int max = 0;
    int[] bucket = new int[128];
    while (r < s.length()) {
      char c = s.charAt(r);
      // already exist
      if (bucket[c] != 0) {
        while (l < r) {
          char d = s.charAt(l);
          bucket[d]--;
          l++;
          if (c == d) {
            break;
          }
        }
      }

      bucket[c]++;
      max = Math.max(max, r - l + 1);
      r++;
    }

    return max;
  }
}
