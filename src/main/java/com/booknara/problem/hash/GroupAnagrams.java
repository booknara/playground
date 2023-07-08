package com.booknara.problem.hash;

import java.util.*;

/**
 * 49. Group Anagrams (Medium)
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
  // Time complexity: O(n * k), n: the number of strings, k: the maximum length of string
  public List<List<String>> groupAnagrams(String[] strs) {
    // edge case
    List<List<String>> res = new ArrayList<>();
    if (strs == null || strs.length == 0) {
      return res;
    }

    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      String key = generateKey(strs[i]);
      // System.out.println(strs[i] + ":" + key);
      List<String> v = map.getOrDefault(key, new ArrayList<>());
      v.add(strs[i]);
      map.put(key, v);
    }

    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      res.add(entry.getValue());
    }

    return res;
  }

  public String generateKey(String s) {
    int[] bucket = new int[26];
    for (int i = 0; i < s.length(); i++) {
      bucket[s.charAt(i) - 'a']++;
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < bucket.length; i++) {
      // Due to edge case(e.g. ["bdddddddddd","bbbbbbbbbbc"])
      builder.append("#").append(bucket[i]);
    }
    return builder.toString();
  }

  // Time complexity: O(n * klogk), n: the number of strings, k: the maximum length of string
  // Space complexity:
  public List<List<String>> groupAnagrams1(String[] strs) {
    if (strs == null || strs.length == 0) {
      return null;
    }

    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String key = String.valueOf(c);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(s);
    }

    return new ArrayList<>(map.values());
  }
}

/**
 Input: strs = ["eat","tea","tan","ate","nat","bat"]
 "eat", "tea", "ate"
 "tan", "nat"
 "bat"
 Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

 Hash
 <String>, List<String>
 int[] key = new int[26];
 ate
 'e' - 'a' = abcdef         t

  012345         18
 "10000100       1"
 key['e' - 'a']++
 key['a' - 'a']++
 key['t' - 'a']++
 key -> String

 */
