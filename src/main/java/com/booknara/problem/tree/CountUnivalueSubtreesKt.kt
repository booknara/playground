package com.booknara.problem.tree

/**
 * 250. Count Univalue Subtrees (Medium)
 * https://leetcode.com/problems/count-univalue-subtrees/
 */
class CountUnivalueSubtreesKt {
  var res = 0
  // T:O(n), S:O(h)
  fun countUnivalSubtrees(root: TreeNode?): Int {
    isUnivalueTree(root)
    return res
  }

  fun isUnivalueTree(node: TreeNode?): Boolean {
    // base case
    if (node == null) return true

    val left = isUnivalueTree(node.left)
    val right = isUnivalueTree(node.right)
    if (left && right) {
      // left subtree & right subtree is univalue subtree
      if (node.left != null && node.left!!.`val` != node.`val`) return false
      if (node.right != null && node.right!!.`val` != node.`val`) return false

      res++
      return true
    }

    return false
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}