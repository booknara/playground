package com.booknara.problem.hash

/**
 * 454. 4Sum II (Medium)
 * https://leetcode.com/problems/4sum-ii/
 */
class FourSumIIKt {
  // T:O(n^2), S:O(n^2)
  fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    var res = 0
    for (i in A) {
      for (j in B) {
        val sum = i + j
        map[sum] = map.get(sum)?.plus(1) ?: 1
      }
    }

    for (i in C) {
      for (j in D) {
        val sum = i + j
        if (map.containsKey(-sum)) {
          res += map.get(-sum) ?: 0
        }
      }
    }

    return res
  }
}