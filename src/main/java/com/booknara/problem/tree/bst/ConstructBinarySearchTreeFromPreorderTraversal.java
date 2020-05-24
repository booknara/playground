package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal (Medium)
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    int index = 0;

    // T:O(n), S:O(n, skewed tree)
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int min, int max) {
        if (index >= preorder.length) {
            return null;
        }

        int val = preorder[index];
        if (val < min || val > max) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        index++;
        node.left = dfs(preorder, min, val);
        node.right = dfs(preorder, val, max);

        return node;
    }
}
