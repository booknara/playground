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
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        dfs(root, ans, 0);
        return ans;
    }

    public void dfs(TreeNode node, List<Integer> ans, int level) {
        if (node == null) {
            return;
        }

        if (ans.size() == level) {
            ans.add(node.val);
        }

        dfs(node.right, ans, level + 1);
        dfs(node.left, ans, level + 1);
    }
}
