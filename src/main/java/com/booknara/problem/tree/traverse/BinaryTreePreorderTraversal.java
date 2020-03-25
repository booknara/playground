package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal (Medium)
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        preorder(res, root);
        return res;
    }

    public void preorder(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        preorder(list, node.left);
        preorder(list, node.right);
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            if (node == null) {
                node = stack.pop().right;
            } else {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
        }

        return res;
    }
}
