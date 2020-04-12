package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal (Medium)
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int rootIdx = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        rootIdx = postorder.length - 1;
        return dfs(0, inorder.length, inorder, postorder);
    }

    private TreeNode dfs(int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (inStart >= inEnd) return null;

        TreeNode root = new TreeNode(postorder[rootIdx--]);
        int inIndex = map.get(root.val);

        root.right = dfs(inIndex + 1, inEnd, inorder, postorder);
        root.left = dfs(inStart, inIndex, inorder, postorder);

        return root;
    }
}
