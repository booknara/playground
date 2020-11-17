package com.booknara.problem.tree

/**
 * 101. Symmetric Tree (Easy)
 * https://leetcode.com/problems/symmetric-tree/
 */
class SymmetricTreeKt {
    // T:O(n), S:O(h)
    fun isSymmetric(root: TreeNode?): Boolean {
        return isMirror(root, root)
    }

    fun isMirror(node1: TreeNode?, node2: TreeNode?): Boolean {
        // base case
        if (node1 == null && node2 == null) return true
        if (node1 == null || node2 == null) return false

        if (node1.`val` != node2.`val`) return false

        val outside = isMirror(node1.left, node2.right)
        val inside = isMirror(node1.right, node2.left)

        return outside && inside
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}