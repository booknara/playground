package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 337. House Robber III (Medium)
 * https://leetcode.com/problems/house-robber-iii/
 */
public class HouseRobberIII {
    // T:O(n), S:(h)
    public int rob(TreeNode root) {

        if (root == null) return 0;

        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[2];

        // left side
        int[] left = dfs(node.left);
        // right side
        int[] right = dfs(node.right);

        int[] res = new int[2];
        // res[0]: with robbing this node, res[1]: without robbing this node
        res[0] = left[1] + right[1] + node.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}
