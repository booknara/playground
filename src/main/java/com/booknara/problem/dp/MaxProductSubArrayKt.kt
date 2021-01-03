package com.booknara.problem.dp

/**
 * 152. Maximum Product Subarray (Medium)
 * https://leetcode.com/problems/maximum-product-subarray/
 */
class MaxProductSubArrayKt {
  // T:O(n), S:O(1)
  fun maxProduct(nums: IntArray): Int {
    // input check
    if (nums.isEmpty()) return 0

    var max = Int.MIN_VALUE
    var cur = 1
    // left -> right
    for (n in nums) {
      if (cur == 0) {
        cur = n
      } else {
        cur *= n
      }

      max = Math.max(max, cur)
    }

    cur = 1
    // right -> left
    for (i in nums.size - 1 downTo 0) {
      if (cur == 0) {
        cur = nums[i]
      } else {
        cur *= nums[i]
      }

      max = Math.max(max, cur)
    }

    return max
  }
}