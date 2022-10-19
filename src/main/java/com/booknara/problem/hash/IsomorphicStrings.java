package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 205. Isomorphic Strings (Easy)
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {
  // T:O(n), S:O(1)
  public boolean isIsomorphic(String s, String t) {
    // input check
    int len = s.length();
    int[] s1 = new int[256];
    int[] s2 = new int[256];
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      char d = t.charAt(i);

      if (s1[c] == 0 && s2[d] == 0) {
        s1[c] = d;
        s2[d] = c;
      } else if (s1[c] != d && s2[d] != c) {
        return false;
      }
    }

    return true;
  }

  // T:O(n), S:O(n)
  public boolean isIsomorphic1(String s, String t) {
    // input check
    int len = s.length();
    // Optimize space using array[256]
    Map<Character, Character> map = new HashMap<>();
    Set<Character> assigned = new HashSet<>();
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      char d = t.charAt(i);
      if (map.containsKey(c)) {
        if (map.get(c) != d) return false;
      } else {
        if (assigned.contains(d)) return false;
        map.put(c, d);
        assigned.add(d);
      }
    }

    return true;
  }

  // T:O(n), S:O(1)
  public boolean isIsomorphic2(String s, String t) {
    // input check, s and t have the same length
    if (s.length() == 0 || t.length() == 0) return true;

    int[] bucket1 = new int[256];
    int[] bucket2 = new int[256];
    for (int i = 0; i < s.length(); i++) {
      if (bucket1[s.charAt(i)] != bucket2[t.charAt(i)]) {
        return false;
      }
      bucket1[s.charAt(i)] = i + 1;
      bucket2[t.charAt(i)] = i + 1;
    }

    return true;
  }
}
