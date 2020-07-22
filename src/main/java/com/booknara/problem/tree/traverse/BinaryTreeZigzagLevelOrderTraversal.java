package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal (Medium)
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    // T:O(n), S:O(h)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, 1, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        if (res.size() < level) {
            res.add(new LinkedList<>());
        }

        if (level % 2 == 0) {
            // Even (right -> left)
            res.get(level - 1).add(0, node.val);
        } else {
            // Odd (left -> right)
            res.get(level - 1).add(node.val);
        }

        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }

    // T:O(n), S:O(h)
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();

            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode n = queue.poll();
                if ((depth & 1) == 0) {
                    // even
                    list.addLast(n.val);
                } else {
                    // odd
                    list.addFirst(n.val);
                }

                if (n.left != null) {
                    queue.offer(n.left);
                }

                if (n.right != null) {
                    queue.offer(n.right);
                }
            }

            res.add(list);
            depth++;
        }

        return res;
    }
}
