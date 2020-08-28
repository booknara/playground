package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View (Medium)
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    // Using DFS
    // T:O(n), S:O(h)
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

    // Using BFS
    // T:O(n), S:O(h)
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (i == 0) {
                    res.add(node.val);
                }

                // right first
                if (node.right != null) {
                    q.offer(node.right);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
            }
        }

        return res;
    }
}
