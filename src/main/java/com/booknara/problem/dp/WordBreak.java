package com.booknara.problem.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break (Medium)
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {
    Set<String> set = new HashSet<>();
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        set.addAll(wordDict);
        memo = new Boolean[s.length()];
        return dfs(s, 0, memo);
    }

    public boolean dfs(String s, int start, Boolean[] memo) {
        //System.out.println("start : " + start);
        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (set.contains(s.substring(start, i))
                    && dfs(s, i, memo)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }
}
