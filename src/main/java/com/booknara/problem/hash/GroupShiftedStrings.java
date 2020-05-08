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
    // T:O(n*m), S:O(n*m)
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            int offset = strings[i].charAt(0) - 'a';
            //System.out.println(offset);

            char[] aligned = new char[strings[i].length()];
            for (int j = 0; j < strings[i].length(); j++) {
                char c = strings[i].charAt(j);
                if (c - offset < 'a') {
                    // For the case of "xa" -> offset of x is 23
                    aligned[j] = (char) (c - offset + 26 + 'a');
                } else {
                    aligned[j] = (char) (c - offset + 'a');
                }
            }

            String key = new String(aligned);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strings[i]);
            map.put(key, list);
        }

        for (List<String> list: map.values()) {
            res.add(list);
        }

        return res;
    }
}
