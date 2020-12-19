package com.booknara.problem.array

/**
 * 334. Increasing Triplet Subsequence (Medium)
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
class IncreasingTripletSubsequenceKt {
  // T:O(n*k), S:O(k)
  fun increasingTriplet(nums: IntArray): Boolean {
    if (nums.size < 3) return false

    val k = 3 // triplet
    val minArray = IntArray(k - 1) { Int.MAX_VALUE }

    for (n in nums) {
      // finding the place for n
      var i = 0
      while (i < minArray.size && n > minArray[i]) {
        i++
      }


      if (i == minArray.size) return true

      minArray[i] = n
    }

    return false
  }
}