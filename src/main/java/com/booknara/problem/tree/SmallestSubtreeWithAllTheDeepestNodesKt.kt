package com.booknara.problem.tree

/**
 * 865. Smallest Subtree with all the Deepest Nodes (Medium)
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
class SmallestSubtreeWithAllTheDeepestNodesKt {
  // T:O(n), S:O(h)
  fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
    return helper(root).first
  }

  fun helper(node: TreeNode?): Pair<TreeNode?, Int> {
    // base case
    if (node == null) return Pair(null, 0)

    val left = helper(node.left)
    val right = helper(node.right)

    if (left.second < right.second) {
      return Pair(right.first, right.second + 1)
    }

    if (left.second > right.second) {
      return Pair(left.first, left.second + 1)
    }

    return Pair(node, left.second + 1)
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}