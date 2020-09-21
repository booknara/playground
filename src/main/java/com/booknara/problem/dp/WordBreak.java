package com.booknara.problem.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break (Medium)
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {
    // T:O(n^2), S:O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        // input check, s is non-empty, wordDic is non-empty
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // list to set
        Set<String> set = new HashSet<>(wordDict);

        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;   // no need to follow up

            for (int j = i + 1; j < n + 1; j++) {
                String sub = s.substring(i, j);
                if (set.contains(sub)) {
                    dp[j] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
/**
 Input: s = "applepenapple", wordDict = ["apple", "pen"]
 01234
 "applepenapple"
 tfffft
 Output: true

 Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 "catsandog"
 tffttfftft
 Output: false
 */