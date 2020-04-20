package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leet code: 199. Binary Tree Right Side View (Medium)
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    // Using DFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, res, 1);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> ans, int level) {
        if (node == null) {
            return;
        }

        if (ans.size() < level) {
            ans.add(node.val);
        }

        // Key point: visit right side first
        dfs(node.right, ans, level + 1);
        dfs(node.left, ans, level + 1);
    }
}
