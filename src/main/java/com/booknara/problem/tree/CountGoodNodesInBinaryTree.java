package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 1448. Count Good Nodes in Binary Tree (Medium)
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class CountGoodNodesInBinaryTree {
    // T:O(n), S:O(h)
    int count = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        count++;
        if (root.left != null)
            dfs(root.left, root.val);
        if (root.right != null)
            dfs(root.right, root.val);
        return count;
    }

    public void dfs(TreeNode node, int max) {
        if (node == null) return;

        if (node.val >= max) {
            count++;
            max = node.val;
        }

        if (node.left != null) dfs(node.left, max);
        if (node.right != null) dfs(node.right, max);
    }
}
