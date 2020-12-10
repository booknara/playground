package com.booknara.problem.search.binary

import java.util.*

/**
 * 938. Range Sum of BST (Easy)
 * https://leetcode.com/problems/range-sum-of-bst/
 */
class RangeSumOfBSTKt {
  var res = 0

  // T:O(n), S:O(h)
  fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    helper(root, low, high)
    return res
  }

  fun helper(node: TreeNode?, low: Int, high: Int) {
    // base case
    if (node == null) return

    if (node.`val` in low..high)
      res += node.`val`

    if (low < node.`val`) {
      helper(node.left, low, high)
    }
    if (node.`val` < high) {
      helper(node.right, low, high)
    }
  }

  // T:O(n), S:O(h)
  fun rangeSumBST1(root: TreeNode?, low: Int, high: Int): Int {
    // input check, the number of nodes >= 1

    val queue = LinkedList<TreeNode>()
    queue.offer(root)

    var res = 0
    while (!queue.isEmpty()) {
      val size = queue.size
      for (i in 0 until size) {
        val node = queue.poll()

        val num = node.`val`
        if (num in low..high) {
          res += num
        }

        if (num >= low && node.left != null) {
          queue.offer(node.left)
        }
        if (num <= high && node.right != null) {
          queue.offer(node.right)
        }
      }
    }

    return res
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}