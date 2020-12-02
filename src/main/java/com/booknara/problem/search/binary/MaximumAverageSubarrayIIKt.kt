package com.booknara.problem.search.binary

/**
 * 644. Maximum Average Subarray II (Hard)
 * https://leetcode.com/problems/maximum-average-subarray-ii/
 */
class MaximumAverageSubarrayIIKt {
  // T:O(n*log((max - min) / 0.00001), S:O(n)
  fun findMaxAverage(nums: IntArray, k: Int): Double {
    var l = -10001.0
    var r = 10001.0
    while (l + 0.00001 < r) {
      val mid = l + (r - l) / 2.0
      if (canFindLargerAverage(nums, mid, k)) {
        l = mid
      } else {
        r = mid
      }
    }

    return l
  }

  fun canFindLargerAverage(nums: IntArray, mid: Double, k: Int): Boolean {
    val size = nums.size

    var prev = 0.0
    var cur = 0.0
    // equal to k
    for (i in 0 until k) {
      cur += nums[i] - mid
    }

    if (cur >= 0) return true

    for (i in k until size) {
      cur += nums[i] - mid
      prev += nums[i - k] - mid
      if (prev < 0.0) {
        cur -= prev
        prev = 0.0
      }

      if (cur >= 0.0) return true
    }
    return false
  }
}