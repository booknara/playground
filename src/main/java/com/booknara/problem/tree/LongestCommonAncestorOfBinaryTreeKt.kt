package com.booknara.problem.tree

/**
 * 236. Lowest Common Ancestor of a Binary Tree (Medium)
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
class LongestCommonAncestorOfBinaryTreeKt {
    // T:O(n), S:O(h)
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        // base base
        if (root == null) return null

        if (p?.`val` == root.`val` || q?.`val` == root.`val`) {
            return root
        }

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        if (left == null && right == null) {
            return null
        }

        if (left == null) return right
        if (right == null) return left

        return root;
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}