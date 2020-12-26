package com.booknara.problem.array

/**
 * 541. Reverse String II (Easy)
 * https://leetcode.com/problems/reverse-string-ii/
 */
class ReverseStringII {
  // T:O(n), S:O(1)
  fun reverseStr(s: String, k: Int): String {
    // input check
    if (k == 1) return s

    var i = 0
    val builder = StringBuilder(s)
    val len = builder.length
    while (i < len) {
      val start = i
      val end = Math.min(i + (k - 1), len - 1)
      swap(builder, start, end)

      i += 2 * k
    }

    return builder.toString()
  }

  // l, r: inclusive
  fun swap(s:StringBuilder, l: Int, r: Int) {
    var start = l
    var end = r
    while (start < end) {
      val temp = s[start]
      s[start] = s[end]
      s[end] = temp
      start++
      end--
    }
  }
}
