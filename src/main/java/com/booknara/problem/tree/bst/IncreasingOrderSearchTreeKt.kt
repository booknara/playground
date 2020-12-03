package com.booknara.problem.tree.bst

import java.util.*

/**
 * 897. Increasing Order Search Tree (Easy)
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
class IncreasingOrderSearchTreeKt {
  // T:O(n), S:O(h)
  fun increasingBST(root: TreeNode?): TreeNode? {
    if (root == null) return root

    val stack = Stack<TreeNode>()
    var cur = root
    var prev: TreeNode? = null
    var res: TreeNode? = null

    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.push(cur)
        cur = cur.left
      }

      cur = stack.pop()
      if (prev == null) {
        // head
        res = cur
      } else {
        prev.right = cur
        prev.left = null
      }

      prev = cur
      // println(prev.`val`)
      cur = cur.right
    }

    prev?.left = null

    return res
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}