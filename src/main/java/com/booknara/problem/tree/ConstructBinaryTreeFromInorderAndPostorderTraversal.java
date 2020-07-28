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
    // T:O(n), S:O(n)
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

    // without global root index
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        // input check, inorder, postorder is not null
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                map);
    }

    public TreeNode dfs(int[] inorder, int inStart, int inEnd,
                        int[] postorder, int postStart, int postEnd,
                        Map<Integer, Integer> map) {
        // base case
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postEnd]);
        int index = map.get(node.val);
        int numOfLeft = index - inStart;

        node.left = dfs(inorder, inStart, index - 1,
                postorder, postStart, numOfLeft + postStart - 1,
                map);

        node.right = dfs(inorder, index + 1, inEnd,
                postorder, numOfLeft + postStart, postEnd - 1,
                map);

        return node;
    }

}
