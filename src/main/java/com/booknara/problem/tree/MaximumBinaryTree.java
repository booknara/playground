package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

/**
 * 654. Maximum Binary Tree (Medium)
 * https://leetcode.com/problems/maximum-binary-tree/
 */
public class MaximumBinaryTree {
    // T:O(n), S:(h)
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // input check, the size of the given array is [1, 1000]
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }

        // find the max value
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = build(nums, start, idx - 1);
        node.right = build(nums, idx + 1, end);

        return node;
    }
}
