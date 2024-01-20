package com.booknara.problem.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 833. Find And Replace in String (Medium)
 * https://leetcode.com/problems/find-and-replace-in-string
 */
public class FindAndReplaceInString {
  // T:O(n*m), S:O(m)
  public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < indices.length; i++) {
      if (s.startsWith(sources[i], indices[i])) {
        // indices's value
        map.put(indices[i], i);
      }
    }

    StringBuilder res = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(i)) {
        int sIndex = map.get(i);
        res.append(targets[sIndex]);
        i += sources[sIndex].length() - 1;
      } else {
        // no replace
        res.append(s.charAt(i));
      }
    }

    return res.toString();
  }
}
