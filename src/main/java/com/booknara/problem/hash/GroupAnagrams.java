package com.booknara.problem.hash;

import java.util.*;

/**
 * 49. Group Anagrams (Medium)
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    // Time complexity: O(n * k), n: the number of strings, k: the maximum length of string
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] bucket = new int[26];
            for (char c: str.toCharArray()) {
                bucket[c - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                builder.append("#").append(bucket[i]);
            }

            List<String> list = map.getOrDefault(builder.toString(), new ArrayList<>());
            list.add(str);
            map.put(builder.toString(), list);
        }

        res.addAll(map.values());
        return res;
    }

    // Time complexity: O(n * klogk), n: the number of strings, k: the maximum length of string
    // Space complexity:
    public List<List<String>> groupAnagrams1(String[] strs) {
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
}
