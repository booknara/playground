package com.booknara.problem.tree.traverse

import java.util.*

/**
 * 103. Binary Tree Zigzag Level Order Traversal (Medium)
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
class BinaryTreeZigzagLevelOrderTraversalKt {
  // T:O(n), S:O(h)
  fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    // input check
    val res = mutableListOf<LinkedList<Int>>()
    if (root == null) return res

    val q = LinkedList<TreeNode>()
    q.offer(root)

    var level = 0
    while (!q.isEmpty()) {
      val size = q.size

      val list = LinkedList<Int>()
      for (i in 0 until size) {
        val n = q.poll()
        if (level % 2 == 0) {
          list.addLast(n.`val`)
        } else {
          list.addFirst(n.`val`)
        }


        if (n.left != null) {
          q.offer(n.left)
        }

        if (n.right != null) {
          q.offer(n.right)
        }
      }

      res.add(list)
      level++
    }

    return res
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}