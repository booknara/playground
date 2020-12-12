package com.booknara.problem.twopointers

/**
 * 80. Remove Duplicates from Sorted Array II (Medium)
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
class RemoveDuplicatesFromSortedArrayIIKt {
  // T:O(n), S:O(1)
  fun removeDuplicates(nums: IntArray): Int {
    if (nums.size <= 2) return nums.size

    var l = 1
    var r = 1
    var count = 1
    while (r < nums.size) {
      if (nums[r - 1] != nums[r]) {
        count = 1
        nums[l] = nums[r]
        r++
        l++
      } else if (count < 2) {
        count++
        nums[l] = nums[r]
        r++
        l++
      } else {
        r++
      }
    }

    return l
  }
}