package com.booknara.problem.array

/**
 * 163. Missing Ranges (Easy)
 * https://leetcode.com/problems/missing-ranges/submissions/
 */
class MissingRangesKt {
  // T:O(n), S:O(1)
  fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {
    val res = ArrayList<String>()

    var start = lower
    for (i in nums.indices) {
      val num = nums[i]
      //println(num)

      if (start <= num - 1) {
        res.add(getRange(start, num - 1))
      }
      start = num + 1
    }

    if (start <= upper) {
      res.add(getRange(start, upper))
    }

    return res
  }

  fun getRange(start: Int, end: Int) = if (start == end) start.toString() else "$start->$end"
}