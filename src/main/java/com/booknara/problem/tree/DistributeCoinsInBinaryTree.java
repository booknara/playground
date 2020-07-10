package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 979. Distribute Coins in Binary Tree (Medium)
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 */
public class DistributeCoinsInBinaryTree {
    // Post-traverse
    // T:O(n), S:O(h)
    int res = 0;
    public int distributeCoins(TreeNode root) {
        if (root == null) return 0;

        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);
        res += Math.abs(l) + Math.abs(r);
        //System.out.println(node.val);
        // Note: do not use abs (e.g. [4,0,null,null,0,null,0])
        return node.val + l + r - 1;
    }
}
