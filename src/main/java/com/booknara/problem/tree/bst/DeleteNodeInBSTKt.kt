package com.booknara.problem.tree.bst

/**
 * 450. Delete Node in a BST (Medium)
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
class DeleteNodeInBSTKt {
    // T:O(logn), S:O(1)
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        var node = root

        if (node == null) return null

        if (node.`val` > key) {
            node.left = deleteNode(node.left, key)
        } else if (node.`val` < key) {
            node.right = deleteNode(node.right, key)
        } else {
            // node.val == key
            if (node.left == null && node.right == null) {
                node = null
            } else if (node.left == null) {
                node = node.right
            } else if (node.right == null) {
                node = node.left
            } else {
                // node.left and node.right is not null
                val min = minNode(node.right)
                // changing the node val
                node.`val` = min!!.`val`
                node.right = deleteNode(node.right, min.`val`)
            }
        }

        return node
    }

    fun minNode(node: TreeNode?): TreeNode? {
        var n: TreeNode? = node
        var prev: TreeNode? = n
        while (n != null) {
            prev = n
            n = n.left
        }

        return prev
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}