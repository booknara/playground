package com.booknara.problem.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 791. Custom Sort String (Medium)
 * https://leetcode.com/problems/custom-sort-string/
 */
public class CustomSortString {
    // T:O(n), S:O(n)
    public String customSortString(String S, String T) {
        // input check
        if (T == null || T.length() == 0) return "";

        Set<Character> set = new HashSet<>();
        for (char c: S.toCharArray()) {
            set.add(c);
        }

        StringBuilder builder = new StringBuilder();
        int[] bucket = new int[26];
        for (char c: T.toCharArray()) {
            if (!set.contains(c)) {
                builder.append(c);
                continue;
            }
            bucket[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (char c: S.toCharArray()) {
            int idx = c - 'a';
            if (bucket[idx] == 0) {
                continue;
            }

            for (int i = 0; i < bucket[idx]; i++) {
                res.append(c);
            }
        }

        res.append(builder.toString());
        return res.toString();
    }
}
