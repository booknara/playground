package com.booknara.problem.dp

/**
 * 337. House Robber III (Medium)
 * https://leetcode.com/problems/house-robber-iii/
 */
class HouseRobberIIIKt {
  // T:O(n), S:O(h)
  fun rob(root: TreeNode?): Int {
    if (root == null) return 0;

    val res = dfs(root)
    return Math.max(res.first, res.second)
  }

  fun dfs(node: TreeNode?): Pair<Int, Int> {
    // base case
    if (node == null) return Pair(0, 0)

    val left = dfs(node.left)
    val right = dfs(node.right)
    // Pair.first: pprev, Pair.second: prev
    val prev = left.first + right.first + node.`val`
    val pprev = left.second + right.second

    return Pair(pprev, Math.max(pprev, prev))
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}