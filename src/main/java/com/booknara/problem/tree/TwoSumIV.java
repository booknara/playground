package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. Two Sum IV - Input is a BST (Easy)
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode node, Set<Integer> set, int k) {
        if (node == null) {
            return false;
        }

        if (set.contains(node.val)) {
            return true;
        }

        set.add(k - node.val);
        return dfs(node.left, set, k) || dfs(node.right, set, k);
    }
}
