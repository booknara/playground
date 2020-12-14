package com.booknara.problem.dp

/**
 * Leet code : 312. Burst Balloons (Hard)
 * https://leetcode.com/problems/burst-balloons/
 */
class BurstBalloonsKt {
  // T:O(n^2), S:O(n^2)
  fun maxCoins(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    val len = nums.size + 2
    val input = IntArray(len) { 0 }
    nums.copyInto(input, 1)
    input[0] = 1
    input[len - 1] = 1
    val dp = Array(len) { IntArray(len) { 0 } }

    for (gap in 2..len) {
      for (left in 0 until len-gap) {
        var cur = 0
        val right = left + gap
        for (i in left + 1 until right) {
          cur = Math.max(cur, dp[left][i] + dp[i][right] + input[left] * input[i] * input[right])
        }

        dp[left][right] = cur
      }
    }

    return dp[0][len - 1]
  }
}