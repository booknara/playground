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
        // input check, s = non-empty string, wordDic = non-empty list
        int n = s.length();

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;

            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1); // inclusive, exclusive
                if (set.contains(sub)) {
                    dp[j + 1] = true;
                }
            }
        }

        return dp[n];
    }
}
/**
 Input: s =
 "leetcode", wordDict = ["leet", "code"]
 [tffftffft]
 booleanp[] dp = new boolean[s.length()];

 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".

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