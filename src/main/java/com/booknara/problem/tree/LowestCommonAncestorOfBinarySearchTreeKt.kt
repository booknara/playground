package com.booknara.problem.tree

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree (Easy)
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
class LowestCommonAncestorOfBinarySearchTreeKt {
  // T:O(h), S:O(h)
  fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (p!!.`val` > q!!.`val`) return lowestCommonAncestor(root, q, p)

    // base case
    if (root == null) return null

    if (root.`val` == p.`val` || root.`val` == q.`val`) return root

    if (p.`val` < root.`val` && root.`val` < q.`val`) return root

    return lowestCommonAncestor(root.left, p, q) ?: lowestCommonAncestor(root.right, p, q)
  }

  class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
  }
}