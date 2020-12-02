package com.booknara.problem.tree

import java.util.*

/**
 * 637. Average of Levels in Binary Tree (Easy)
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
class AverageOfLevelsBinaryTreeKt {
  // T:O(n), S:O(h)
  fun averageOfLevels(root: TreeNode?): DoubleArray {
    val res = mutableListOf<Double>()
    if (root == null) return res.toDoubleArray()

    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    while (!queue.isEmpty()) {
      val size = queue.size
      var sum = 0.0
      for (i in 0 until size) {
        val node = queue.poll()

        sum += node.`val`
        if (node.left != null) {
          queue.offer(node.left)
        }
        if (node.right != null) {
          queue.offer(node.right)
        }
      }

      res.add(sum / size)
    }

    return res.toDoubleArray()
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}