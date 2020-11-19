package com.booknara.problem.tree

/**
 * 543. Diameter of Binary Tree (Easy)
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
class DiameterBinaryTreeKt {
  var res = 0
  // T:O(n), S:O(h)
  fun diameterOfBinaryTree(root: TreeNode?): Int {
    getDiameter(root)
    return res
  }

  fun getDiameter(node: TreeNode?): Int {
    // base case
    if (node == null) return 0

    val left = getDiameter(node.left)
    val right = getDiameter(node.right)
    res = Math.max(res, left + right)

    return Math.max(left, right) + 1
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}