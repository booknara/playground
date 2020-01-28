package com.booknara.problem.hash;

import java.util.*;

/**
 * Leet code : 49. Group Anagrams (Medium)
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Anagram : An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class GroupAnagrams {
    // Time complexity: O(n * klogk), n: the number of strings, k: the maximum length of string
    // Space complexity:
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
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

    // Time complexity: O(n * k), n: the number of strings, k: the maximum length of string
    public List<List<String>> groupAnagramsOptimized(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            int[] count = new int[26];
            for (char c: s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                builder.append(count[i]);
            }

            String key = builder.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

}
