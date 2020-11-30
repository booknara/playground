package com.booknara.problem.twopointers

/**
 * 643. Maximum Average Subarray I (Easy)
 * https://leetcode.com/problems/maximum-average-subarray-i/
 */
class MaximumAverageSubarrayIKt {
  // T:O(n), S:O(1)
  fun findMaxAverage(nums: IntArray, k: Int): Double {
    var l = 0
    var r = 0
    var sum = 0.0
    var max = Int.MIN_VALUE.toDouble()
    while (r < nums.size) {
      sum += nums[r]

      if (r - l + 1 == k) {
        max = Math.max(max, sum / k.toDouble())

        sum -= nums[l]
        l++
      }
      r++
    }

    return max
  }
}