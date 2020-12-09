package com.booknara.problem.hash

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60 (Medium)
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */
class PairsOfSongsWithTotalDurationsDivisibleBy60Kt {
  // T:O(n), S:O(1)
  fun numPairsDivisibleBy60(time: IntArray): Int {
    if (time.size == 1) return 0

    var res = 0
    val map = mutableMapOf<Int, Int>()
    for (i in time.indices) {
      val mod = time[i] % 60  // 0 ~ 59

      val rest = (60 - mod) % 60
      res += map.getOrDefault(rest, 0)

      map.put(mod, map.getOrDefault(mod, 0) + 1)
    }

    return res
  }
}