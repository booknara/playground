package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.*;

/**
 * 1110. Delete Nodes And Return Forest (Medium)
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
public class DeleteNodesAndReturnForest {
    // T:O(n), S:O(h), recursive
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new LinkedList<>();
        if (root == null) return res;

        Set<Integer> set = new HashSet<>();
        // to_delete to Set
        for (int i: to_delete) {
            set.add(i);
        }

        if (!set.contains(root.val)) {
            res.add(root);
        }

        dfs(root, null, res, set);

        return res;
    }

    public void dfs(TreeNode node, TreeNode parent, List<TreeNode> res, Set<Integer> set) {
        if (node == null) return;

        if (set.contains(node.val)) {
            if (parent != null) {
                // find node btw parent.left or parent.right to disconnect
                if (parent.left != null && parent.left.val == node.val) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

            // add children nodes
            if (node.left != null && !set.contains(node.left.val)) {
                res.add(node.left);
            }

            if (node.right != null && !set.contains(node.right.val)) {
                res.add(node.right);
            }
        }

        dfs(node.left, node, res, set);
        dfs(node.right, node, res, set);
    }

    // T:O(n), S:O(h), iterative
    public List<TreeNode> delNodes1(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new LinkedList<>();
        if (root == null) return res;

        Set<Integer> set = new HashSet<>();
        // to_delete to Set
        for (int i: to_delete) {
            set.add(i);
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        res.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (set.contains(node.val)) {
                res.remove(node);
                if (node.left != null) {
                    res.add(node.left);
                }
                if (node.right != null) {
                    res.add(node.right);
                }
            }

            if (node.left != null) {
                q.offer(node.left);
                // disconnect child node since it also should be removed
                if (set.contains(node.left.val)) {
                    node.left = null;
                }
            }
            if (node.right != null) {
                q.offer(node.right);
                // disconnect child node since it also should be removed
                if (set.contains(node.right.val)) {
                    node.right = null;
                }
            }
        }

        return res;
    }
}
