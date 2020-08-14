package com.booknara.problem.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 291. Word Pattern II (Hard)
 * https://leetcode.com/problems/word-pattern-ii/
 */
public class WordPatternII {
    // T:O(n!/(n-m)!, exponential), S:(n)
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() == 0 && str.length() == 0) return true;
        if (pattern.length() * str.length() == 0) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return backtracking(pattern, 0, str, 0, map, set);
    }

    public boolean backtracking(String pattern,
                                int pIdx,
                                String str,
                                int sIdx,
                                Map<Character, String> map,
                                Set<String> set) {
        // base case
        if (pIdx == pattern.length() && sIdx == str.length()) {
            return true;
        }

        if (pIdx >= pattern.length() || sIdx >= str.length()) {
            return false;
        }

        char p = pattern.charAt(pIdx);
        for (int i = sIdx + 1; i <= str.length(); i++) {
            String sub = str.substring(sIdx, i);

            if (!map.containsKey(p) && !set.contains(sub)) {
                // not exist pattern and substring
                map.put(p, sub);
                set.add(sub);
                if (backtracking(pattern, pIdx + 1, str, i, map, set)) {
                    return true;
                }
                map.remove(p);
                set.remove(sub);
            } else if (map.containsKey(p) && map.get(p).equals(sub)) {
                // exist pattern and substring
                if (backtracking(pattern, pIdx + 1, str, i, map, set)) {
                    return true;
                }
            }
        }

        return false;
    }
}
