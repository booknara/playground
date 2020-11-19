package com.booknara.problem.tree

import java.util.*

/**
 * 111. Minimum Depth of Binary Tree (Easy)
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
class MinimumDepthOfBinaryTreeKt {
  // T:O(n), S:O(n)
  fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0;

    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    var level = 1
    while (!queue.isEmpty()) {
      val size = queue.size
      for (i in 0 until size) {
        val node = queue.poll()

        if (node.left == null && node.right == null) return level

        node.left?.let {
          queue.offer(it)
        }
        node.right?.let {
          queue.offer(it)
        }
      }

      level++
    }

    return level
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}