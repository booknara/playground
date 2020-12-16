package com.booknara.problem.twopointers

/**
 * 977. Squares of a Sorted Array (Easy)
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
class SquaresOfSortedArrayKt {
  // T:O(n), S:O(n)
  fun sortedSquares(nums: IntArray): IntArray {
    //var res = nums.copyOf()
    var res = IntArray(nums.size) { 0 }
    var l = 0
    var r = nums.size - 1
    var idx = res.size - 1
    while (l <= r) {
      if (Math.abs(nums[l]) < Math.abs(nums[r])) {
        res[idx--] = nums[r] * nums[r]
        r--
      } else {
        res[idx--] = nums[l] * nums[l]
        l++
      }
    }

    return res
  }
}