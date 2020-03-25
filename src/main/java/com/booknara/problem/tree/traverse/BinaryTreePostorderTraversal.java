package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal (Hard)
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        postorder(res, root);
        return res;
    }

    public void postorder(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        postorder(list, node.left);
        postorder(list, node.right);
        list.add(node.val);
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            res.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }

            if (node.right != null) {
                stack.add(node.right);
            }
        }

        return res;
    }
}
