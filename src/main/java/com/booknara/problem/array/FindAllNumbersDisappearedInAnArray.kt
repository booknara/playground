package com.booknara.problem.array

/**
 * 448. Find All Numbers Disappeared in an Array (Easy)
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
class Solution {
    // T:O(n), S:O(1)
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        // input check, the size of array >= 1
        val res = mutableListOf<Int>()

        for ((index, value) in nums.withIndex()) {
            // println("The element at $index is $value")
            val idx = nums[Math.abs(value) - 1]
            nums[Math.abs(value) - 1] = -Math.abs(idx);
        }

        for ((index, value) in nums.withIndex()) {
            if (nums[index] > 0) {
                res.add(index + 1)
            }
        }

        return res
    }
}
