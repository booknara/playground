package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal (Medium)
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    // T:O(n), SO(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, res, 0);

        return res;
    }

    public void dfs(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.val);
        dfs(node.left, res, level + 1);
        dfs(node.right, res, level + 1);
    }

    // T:O(n), SO(n)
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // input check
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (res.size() == level) {
                res.add(new ArrayList<>());
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                res.get(level).add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            level++;
        }

        return res;
    }
}
