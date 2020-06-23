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
}
