package com.booknara.problem.array

/**
 * 56. Merge Intervals (Medium)
 * https://leetcode.com/problems/merge-intervals/
 */
class MergeIntervalsKt {
  // T:O(n*logn), S:O(1)
  fun merge(intervals: Array<IntArray>): Array<IntArray> {
    // input check
    if (intervals.size <= 1) return intervals

    // sort
    intervals.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })

    // intervals.forEach {
    //   println(it.joinToString())
    // }

    val list = mutableListOf<IntArray>()
    var prev = intervals[0]
    for (i in 1 until intervals.size) {
      val cur = intervals[i]
      if (cur[0] <= prev[1]) {
        // overlapped
        prev[0] = Math.min(prev[0], cur[0])
        prev[1] = Math.max(prev[1], cur[1])
      } else {
        // not-overlapped
        list.add(prev)
        prev = cur
      }
    }

    list.add(prev)

    return list.toTypedArray()
  }
}