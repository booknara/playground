package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 437. Path Sum III (Easy)
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return pathSumFrom(root, sum)
                + pathSumFrom(root.left, sum)
                + pathSumFrom(root.right, sum);
    }

    public int pathSumFrom(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val)
                + pathSumFrom(node.right, sum - node.val);
    }
}
