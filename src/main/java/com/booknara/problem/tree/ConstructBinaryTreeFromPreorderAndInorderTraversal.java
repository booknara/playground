package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal (Medium)
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int rootIdx = 0;
    // T:O(n), S:O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // input check
        if (preorder == null || preorder.length == 0
                || inorder == null || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder,
                inorder, 0, inorder.length - 1,
                map);
    }

    public TreeNode build(int[] preorder,
                          int[] inorder, int inStart, int inEnd,
                          Map<Integer, Integer> map) {
        // base case
        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[rootIdx++]);
        int idx = map.get(node.val);

        node.left = build(preorder, inorder, inStart, idx - 1, map);
        node.right = build(preorder, inorder, idx + 1, inEnd, map);

        return node;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
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
