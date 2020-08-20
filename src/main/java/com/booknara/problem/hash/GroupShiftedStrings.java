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

    public List<List<String>> groupStrings1(String[] strings) {
        // input check
        List<List<String>> res = new ArrayList<>();
        if (strings.length == 0) return res;

        // Assumption input strings contains the lowercase letter
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            StringBuilder key = new StringBuilder();
            String s = strings[i];
            if (s.length() == 1) {
                // "a", "b"
                key.append("a");
            } else {
                // bcd -> offset = 'b' - 'a' = 1
                for (int j = 1; j < s.length(); j++) {
                    int diff = s.charAt(j) - s.charAt(j - 1);
                    if (diff < 0) {
                        diff += 26;
                    }
                    key.append(diff);
                }
            }

            // after converting string to key
            List<String> list = map.getOrDefault(key.toString(), new ArrayList<>());
            list.add(s);
            map.put(key.toString(), list);
        }

        res.addAll(map.values());

        return res;
    }

}
