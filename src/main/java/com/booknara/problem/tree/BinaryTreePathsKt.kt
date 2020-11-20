package com.booknara.problem.tree

/**
 * 257. Binary Tree Paths (Easy)
 * https://leetcode.com/problems/binary-tree-paths/
 */
class BinaryTreePathsKt {
  // T:O(n), S:O(h)
  fun binaryTreePaths(root: TreeNode?): List<String> {
    val res = mutableListOf<String>()

    dfs(root, StringBuilder(), res)
    return res
  }

  fun dfs(node: TreeNode?, builder: StringBuilder, res: MutableList<String>) {
    // base case
    if (node == null) return

    if (node.left == null && node.right == null) {
      // leaf node
      builder.append(node.`val`)
      res.add(builder.toString())
      return
    }

    builder.append(node.`val`).append("->")
    dfs(node.left, StringBuilder(builder.toString()), res)
    dfs(node.right, StringBuilder(builder.toString()), res)
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}