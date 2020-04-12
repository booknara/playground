package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal (Medium)
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode dfs(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }

        root.left = dfs(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // preStart = preStart + 1 and move more which is left subtree having right child nodes
        root.right = dfs(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

        return root;
    }
}
