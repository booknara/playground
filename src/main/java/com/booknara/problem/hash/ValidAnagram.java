package com.booknara.problem.hash;

import java.util.Arrays;

/**
 * 242. Valid Anagram (Easy)
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {
  // T:O(n), S:O(1), Unicode applicable
  public boolean isAnagram(String s, String t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;

    if (s.length() != t.length()) return false;

    int[] count = new int[256];
    for (char c : s.toCharArray()) {
      count[c]++;
    }
    for (char c : t.toCharArray()) {
      count[c]--;
    }

    for (int i = 0; i < 256; i++) {
      if (count[i] != 0) return false;
    }

    return true;
  }

  // O(n), alphabet applicable only
  public boolean isAnagram1(String s, String t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;

    if (s.length() != t.length()) return false;

    int[] count = new int[26];
    int len = s.length();
    for (int i = 0; i < len; i++) {
      count[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < len; i++) {
      count[t.charAt(i) - 'a']--;
    }

    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) {
        return false;
      }
    }

    return true;
  }

  // O(n * logn)
  public boolean isAnagram2(String s, String t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;

    if (s.length() != t.length()) return false;

    char[] sArr = s.toCharArray();
    char[] tArr = t.toCharArray();
    Arrays.sort(sArr);
    Arrays.sort(tArr);

    int len = sArr.length;
    for (int i = 0; i < len; i++) {
      if (sArr[i] != tArr[i]) return false;
    }

    return true;
  }
}
