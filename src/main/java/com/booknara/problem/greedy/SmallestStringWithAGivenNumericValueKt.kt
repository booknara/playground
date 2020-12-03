package com.booknara.problem.greedy

/**
 * 1663. Smallest String With A Given Numeric Value (Medium)
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 */
class SmallestStringWithAGivenNumericValueKt {
  // T:O(n), S:O(1)
  fun getSmallestString(n: Int, k: Int): String {
    // input check, 1 <= n <= 10^5
    // n = length, k = sum of each character
    var len = n
    var sum = k.toDouble()

    val res = StringBuilder()
    while (len > 1) {
      if (sum / (len - 1) <= 26.0) {
        // enough
        res.append("a")
        sum--
      } else {
        // not enough
        val rem = sum - ((len - 1) * 26)
        //println(rem)
        res.append('a' + rem.toInt() - 1)
        sum -= rem
      }

      len--
    }

    res.append('a' + sum.toInt() - 1)

    return res.toString()
  }
}