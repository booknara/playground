package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal (Medium)
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    int idx;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        idx = 0;
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int start, int end) {
        if (idx >= preorder.length) {
            return null;
        }

        int val = preorder[idx];
        if (val < start || val > end) {
            return null;
        }

        idx++;
        TreeNode root = new TreeNode(val);
        root.left = dfs(preorder, start, root.val);
        root.right = dfs(preorder, root.val, end);

        return root;
    }
}
