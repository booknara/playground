package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

/**
 * 669. Trim a Binary Search Tree (Easy)
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 */
public class TrimBinarySearchTree {
    // T:I(n), S:O(h)
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return dfs(root, L, R);
    }

    public TreeNode dfs(TreeNode node, int L, int R) {
        if (node == null) return null;

        if (node.val < L) {
            // no more left node, but check right node
            if (node.right != null) {
                return dfs(node.right, L, R);
            }

            return null;
        } else if (node.val > R) {
            // no more right node, but check left node
            if (node.left != null) {
                return dfs(node.left, L, R);
            }

            return null;
        } else {
            // L < node.val < R
            node.right = dfs(node.right, L, R);
            node.left = dfs(node.left, L, R);
            return node;
        }
    }
}
