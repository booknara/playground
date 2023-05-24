package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. Unique Number of Occurrences
 * https://leetcode.com/problems/unique-number-of-occurrences
 */
public class UniqueNumberOfOccurrences {
  // T:O(n), S:O(n)
  public boolean uniqueOccurrences(int[] arr) {
    // edge case
    if (arr == null || arr.length == 0) return true;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int val = map.getOrDefault(arr[i], 0);
      map.put(arr[i], val + 1);
    }

    Set<Integer> set = new HashSet<>();
    for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
      if (set.contains(entry.getValue())) {
        return false;
      }
      set.add(entry.getValue());
    }

    return true;
  }
}
/**
 Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 Output: true
 -3: 3
 0: 2
 1: 4
 10: 1

 insert elements to Map<Integer, Integer>
 Iterate map value using hashset -> contains == true -> false
 */
