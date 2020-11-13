package com.booknara.problem.backtracking

import java.util.*

/**
 * 47. Permutations II (Medium)
 * https://leetcode.com/problems/permutations-ii/
 */
class PermutationsIIKt {
    // T:O(n!), S:(n!)
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        // input check, the length of nums >= 1
        val res: MutableList<List<Int>> = ArrayList()

        helper(nums, 0, res)
        return res
    }

    fun helper(nums: IntArray, index: Int, res: MutableList<List<Int>>) {
        // base case
        if (index >= nums.size) {
            val list: MutableList<Int> = ArrayList()
            for (n in nums) {
                list.add(n)
            }
            res.add(list)
            return
        }

        val visited = mutableSetOf<Int>()
        for (i in index until nums.size) {
            if (visited.contains(nums[i])) continue

            visited.add(nums[i])
            // swap i, index
            swap(nums, i, index)
            helper(nums, index + 1, res)
            swap(nums, index, i)
        }
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}