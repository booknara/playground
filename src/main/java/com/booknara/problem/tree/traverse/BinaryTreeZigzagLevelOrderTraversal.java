package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal (Medium)
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
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
}
