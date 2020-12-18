package com.booknara.problem.dp

/**
 * 1143. Longest Common Subsequence (Medium)
 * https://leetcode.com/problems/longest-common-subsequence/
 */
class LongestCommonSubsequenceKt {
  fun longestCommonSubsequence(text1: String, text2: String): Int {
    // input check, text1.length >= 1, text1.length >= 1
    val m = text1.length
    val n = text2.length
    val dp = Array(m + 1) { IntArray(n + 1) { 0 } }

    for (i in text1.indices) {
      for (j in text2.indices) {
        if (text1[i] == text2[j]) {
          dp[i + 1][j + 1] = dp[i][j] + 1
        } else {
          dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1])
        }
      }
    }

    return dp[m][n]
  }
}