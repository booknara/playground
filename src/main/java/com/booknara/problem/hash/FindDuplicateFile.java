package com.booknara.problem.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 609. Find Duplicate File in System (Medium)
 * https://leetcode.com/problems/find-duplicate-file-in-system/
 */
public class FindDuplicateFile {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        if (paths == null || paths.length == 0) {
            return ans;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s: paths) {
            String[] items = s.split(" ");
            if (items.length < 2) {
                continue;
            }

            String directory = "";
            for (int i = 0; i < items.length; i++) {
                if (i == 0) {
                    directory = items[i];
                    continue;
                }

                String file = items[i];
                // System.out.println(items[i]);
                String key = "";
                String fileName = "";
                for (int j = file.length() - 2; j >= 0; j--) {
                    if (file.charAt(j) == '(') {
                        key = file.substring(j + 1, file.length() - 1);
                        //System.out.println(key);
                        fileName = file.substring(0, j);
                        //System.out.println(fileName);
                    }
                }

                List<String> values = map.getOrDefault(key, new ArrayList<String>());
                values.add(directory + "/" + fileName);
                map.put(key, values);
            }
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            // Only a group of duplicated file
            if (entry.getValue().size() > 1) {
                ans.add(entry.getValue());
            }
        }

        return ans;
    }
}
