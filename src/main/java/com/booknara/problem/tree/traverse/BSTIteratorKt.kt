package com.booknara.problem.tree.traverse

import java.util.*

/**
 * 173. Binary Search Tree Iterator (Medium)
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
class BSTIteratorKt(root: TreeNode?) {
  val stack = Stack<TreeNode>()
  var cur: TreeNode? = null
  init {
    cur = root
    push()
  }

  fun push() {
    while (cur != null) {
      stack.push(cur)
      cur = cur!!.left
    }
  }

  // T:O(h)
  /** @return the next smallest number */
  fun next(): Int {
    cur = stack.pop()
    val res = cur!!.`val`
    cur = cur!!.right
    push()

    return res
  }

  // T:O(1)
  /** @return whether we have a next smallest number */
  fun hasNext(): Boolean {
    return !stack.isEmpty()
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    }
}