package com.booknara.problem.tree

/**
 * 1448. Count Good Nodes in Binary Tree (Medium)
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
class CountGoodNodesInBinaryTreeKt {
  var res = 1 // init value because of root node
  fun goodNodes(root: TreeNode?): Int {
    // The number of nodes >= 1
    if (root == null) return 0

    dfs(root.left, root.`val`)
    dfs(root.right, root.`val`)

    return res
  }

  fun dfs(root: TreeNode?, max: Int) {
    if (root == null) return

    var newMax = max
    if (max <= root.`val`) {
      newMax = root.`val`
      res++
    }

    dfs(root.left, newMax)
    dfs(root.right, newMax)
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}
