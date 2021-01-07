package com.booknara.problem.tree.bst

/**
 * 108. Convert Sorted Array to Binary Search Tree (Easy)
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
class ConvertSortedArrayToBinarySearchTreeKt {
  // T:O(n), S:(logn)
  fun sortedArrayToBST(nums: IntArray): TreeNode? {
    // input check
    if (nums.isEmpty()) return null

    return dfs(nums, 0, nums.size - 1)
  }

  // start, end: inclusive
  fun dfs(nums: IntArray, start: Int, end: Int): TreeNode? {
    // base case
    if (start > end) return null

    val mid = start + (end - start) / 2

    val res = TreeNode(nums[mid])
    res.left = dfs(nums, start, mid - 1)
    res.right = dfs(nums, mid + 1, end)

    return res
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}