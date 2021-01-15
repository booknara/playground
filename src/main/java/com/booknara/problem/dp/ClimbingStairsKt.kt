package com.booknara.problem.dp

/**
 * 70. Climbing Stairs (Easy)
 * https://leetcode.com/problems/climbing-stairs/
 */
class ClimbingStairsKt {
  // T:O(n), S:O(1)
  fun climbStairs(n: Int): Int {
    if (n == 1) return 1

    var pprev = 1
    var prev = 1
    var cur = 0

    for (i in 2 until n + 1) {
      cur = pprev + prev
      pprev = prev
      prev = cur
    }

    return cur
  }
}