package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 662. Maximum Width of Binary Tree (Medium)
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class MaximumWidthOfBinaryTree {
    // T:O(n), S:(n)
    int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Map<Integer, Integer> left = new HashMap<>();
        dfs(root, 1, 1, left);

        return max;
    }

    public void dfs(TreeNode node, int depth, int value, Map<Integer, Integer> left) {
        // base case
        if (node == null) return;

        //System.out.println(node.val);
        if (node.left != null) {
            int v = value * 2;
            if (!left.containsKey(depth)) {
                left.put(depth, v);
            } else {
                max = Math.max(max, v - left.get(depth) + 1);
            }

            dfs(node.left, depth + 1, v, left);
        }

        if (node.right != null) {
            int v = value * 2 + 1;
            if (!left.containsKey(depth)) {
                left.put(depth, v);
            } else {
                max = Math.max(max, v - left.get(depth) + 1);
            }
            dfs(node.right, depth + 1, v, left);
        }
    }
}
