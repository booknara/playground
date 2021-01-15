package com.booknara.problem.tree.traverse

/**
 * 404. Sum of Left Leaves (Easy)
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
class SumOfLeftLeavesKt {
  var sum = 0
  // T:O(n), S:O(logn)
  fun sumOfLeftLeaves(root: TreeNode?): Int {
    dfs(root, false)

    return sum
  }

  fun dfs(node: TreeNode?, left: Boolean) {
    //base case
    if (node == null) return

    if (node.left == null && node.right == null) {
      // leave
      if (left) {
        sum += node.`val`
      }
      return
    }

    dfs(node.left, true)
    dfs(node.right, false)
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}