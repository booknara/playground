package com.booknara.problem.search.binary

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

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}