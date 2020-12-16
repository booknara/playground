package com.booknara.problem.tree.bst

/**
 * 98. Validate Binary Search Tree (Medium)
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
class ValidateBSTKt {
  // T:O(n), S:O(h)
  fun isValidBST(root: TreeNode?): Boolean {
    if (root == null) return true

    return helper(root, null, null)
  }

  fun helper(node: TreeNode?, min: Int?, max: Int?): Boolean {
    // base case
    if (node == null) return true

    if (min != null && node.`val` <= min) return false
    if (max != null && node.`val` >= max) return false

    return helper(node.left, min, node.`val`) && helper(node.right, node?.`val`, max)
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}