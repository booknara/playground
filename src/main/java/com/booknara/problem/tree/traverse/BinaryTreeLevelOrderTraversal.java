package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal (Medium)
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
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
}
