package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 1123. Lowest Common Ancestor of Deepest Leaves (Medium)
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */
public class LowestCommonAncestorOfDeepestLeaves {
    // T:O(n), S:O(n)
    Map<TreeNode, Integer> map = new HashMap<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;

        // find the node which has same depth of left and right tree(LCA of deepest leaves)
        if (getHeight(root.left) == getHeight(root.right)) {
            return root;
        }
        // if one side depth is larger than the other side, drill down that node
        if (getHeight(root.left) > getHeight(root.right)) {
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        if (map.containsKey(node)) return map.get(node);

        int h = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        map.put(node, h);
        return h;
    }

    // T:O(n), S:O(h)
    public TreeNode lcaDeepestLeaves1(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;

        PairNode pair = new PairNode();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int depth = 0;
        int max = -1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                depth++;
                if (queue.peek() == null) break;
                else queue.offer(null);
            } else {
                if (max < depth) {
                    pair.first = node;
                    pair.second = null;
                    max = depth;
                } else {
                    pair.second = node;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        // System.out.println(pair.first.val);
        // System.out.println(pair.second.val);

        if (pair.second == null) {
            // only one left node
            return pair.first;
        }

        return dfs(root, pair.first.val, pair.second.val);
    }

    public TreeNode dfs(TreeNode node, int first, int second) {
        if (node == null) {
            return null;
        }

        if (node.val == first || node.val == second) {
            return node;
        }

        TreeNode left = dfs(node.left, first, second);
        TreeNode right = dfs(node.right, first, second);
        if (left == null && right == null) return null;

        if (left == null) return right;
        if (right == null) return left;

        return node;
    }

    static class PairNode {
        TreeNode first;
        TreeNode second;
        PairNode() {
            this.first = null;
            this.first = null;
        }
    }
}
