package com.booknara.problem.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 249. Group Shifted Strings (Medium)
 * https://leetcode.com/problems/group-shifted-strings/
 */
public class GroupShiftedStrings {
    // input: string array
    // output: group all the strings
    // T:O(n*m), S:O(n*m)
    public List<List<String>> groupStrings(String[] strings) {
        // input check
        // 1. input array can be null or empty
        // 2. each string of the array is non-empty string
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            int offset = strings[i].charAt(0) - 'a';
            //System.out.println(offset);
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < strings[i].length(); j++) {
                char c = strings[i].charAt(j);
                if (c - offset < 'a') {
                    c += 26;
                }
                c = (char) (c - offset);

                builder.append(c);
            }

            String key = builder.toString();
            //System.out.println(key);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strings[i]);
            map.put(key, list);
        }

        res.addAll(map.values());

        return res;
    }

    /**
     Given a string, we can "shift" each of its letter to its successive letter,
     for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

     "abc" -> "bcd" -> ... -> "xyz" -> one group
     Given a list of non-empty strings which contains only lowercase alphabets,
     group all strings that belong to the same shifting sequence.

     Example:
     Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
     Output:
     [
     ["abc","bcd","xyz"],
     ["az","ba"],
     ["acef"],
     ["a","z"]
     ]

     Input: non-empty string, lowercase alphabets only
     "abc"
     bcd -> ('b'- 'a') bcd -> abc
     xyz -> ('x'- 'a') xyz -> abc

     "az"
     "ba" -> ('b' - 'a', 1) ba -> az. ba (66, 65) -> (65, 64 + 26)
     After rearranging based on the first letter, if the rearranging number is negative, add 26
     */

    // T:O(n*m), S:O(n*m)
    public List<List<String>> groupStrings1(String[] strings) {
        // input check, strings only contain lowercase
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) return res;

        // Grouping
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strings) {
            String key = shiftString(s);
            //System.out.println(key);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }

        for (List<String> list: map.values()) {
            res.add(list);
        }

        return res;
    }

    public String shiftString(String s) {
        StringBuilder builder = new StringBuilder();
        // shift logic here
        int num = s.charAt(0) - 'a';
        for (char c: s.toCharArray()) {
            if (c - num >= 'a') {
                builder.append((char)(c - num));
            } else {
                builder.append((char)(c - num + 26));
            }
        }

        return builder.toString();
    }
}
