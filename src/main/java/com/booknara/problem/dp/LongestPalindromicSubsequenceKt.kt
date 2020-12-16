package com.booknara.problem.dp

/**
 * 516. Longest Palindromic Subsequence (Medium)
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
class LongestPalindromicSubsequenceKt {
  // T:O(n^2), S:O(n^2)
  fun longestPalindromeSubseq(s: String): Int {
    // input check s.length >= 1
    val n = s.length
    val dp = Array(n, {IntArray(n) { 0 } } )

    for (i in dp.size - 1 downTo 0) {
      val arr = dp[i]
      for (j in i until arr.size) {
        if (i == j) {
          dp[i][j] = 1
          continue
        }

        if (s[i] == s[j]) {
          dp[i][j] = dp[i + 1][j - 1] + 2
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])
        }
      }

      //println(arr.joinToString())
    }

    return dp[0][n - 1]
  }
}
/**
0 b b b a b
b 0 1 2 3 3 4
b 0   1 2 2 3
b 0     1 1 3
a 0       1 1
b 0         1
 */