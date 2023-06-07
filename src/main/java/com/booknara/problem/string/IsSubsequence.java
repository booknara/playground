package com.booknara.problem.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 392. Is Subsequence (Easy)
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {
  // T:O(n), S:O(n), Follow-up problem: Binary searching
  public boolean isSubsequence(String s, String t) {
    if (s.length() == 0) return true;
    if (t.length() == 0) return false;
    if (s.length() > t.length()) return false;  // string s should be smaller than string t

    // build map for string t
    Map<Character, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      List<Integer> list = map.getOrDefault(c, new ArrayList<>());
      list.add(i);
      map.put(c, list);
    }

    return checkSubsequence(s, map);
  }

  // check whether string s is subsequence
  public boolean checkSubsequence(String s, Map<Character, List<Integer>> map) {
    int lastIndex = -1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!map.containsKey(c)) return false; // t doesn't have character of S

      List<Integer> list = map.get(c);
      lastIndex = binarySearch(list, lastIndex);
      if (lastIndex == -1) {
        return false;
      }
    }

    return true;
  }

  public int binarySearch(List<Integer> list, int lastIndex) {
    int res = -1;
    int left = 0, right = list.size() - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (list.get(mid) > lastIndex) {
        res = list.get(mid);
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return res;
  }

  // T:O(n), S:O(1), Linear checking
  public boolean isSubsequence1(String s, String t) {
    if (s.length() == 0) return true;
    if (t.length() == 0) return false;
    if (s.length() > t.length()) return false;  // string s should be smaller than string t

    int sIdx = 0, tIdx = 0;
    while (sIdx < s.length() && tIdx < t.length()) {
      if (s.charAt(sIdx) == t.charAt(tIdx)) {
        sIdx++;
      }
      tIdx++;
    }

    return sIdx == s.length();
  }

  public boolean isSubsequence2(String s, String t) {
    // input check
    if (s.length() > t.length()) {
      // s is longer than t
      return false;
    }

    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      boolean found = false;
      while (j < t.length()) {
        char d = t.charAt(j);
        if (c == d) {
          found = true;
          j++;
          break;
        }
        j++;
      }

      if (!found) return false;
    }

    return true;
  }

  public boolean isSubsequence3(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    if (sLen > tLen) return false;

    int i = 0, j = 0;
    while (i < sLen) {
      while (j < tLen && s.charAt(i) != t.charAt(j)) {
        j++;
      }
      if (j == tLen) return false;  // t is already out of bound
      i++;
      j++;
    }

    return i == sLen;
  }
}
