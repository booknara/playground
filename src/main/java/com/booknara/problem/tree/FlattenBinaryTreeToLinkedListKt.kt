package com.booknara.problem.tree

/**
 * 114. Flatten Binary Tree to Linked List (Medium)
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
class FlattenBinaryTreeToLinkedListKt {
  // T:O(n), S:O(h)
  fun flatten(root: TreeNode?): Unit {
    // input check
    if (root == null) return

    helper(root)
  }

  fun helper(node: TreeNode?): TreeNode? {
    // base case
    if (node == null) return null

    val left = helper(node.left)
    val right = helper(node.right)

    // root
    if (node.left == null) return node

    node.right = left
    node.left = null

    var cur = node.right
    var prev: TreeNode? = null
    while (cur != null) {
      prev = cur
      cur = cur.right
    }

    // cur = null
    prev?.right = right

    return node
  }

  class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}