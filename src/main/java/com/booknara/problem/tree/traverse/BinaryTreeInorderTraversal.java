package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal (Medium)
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {
    // Time complexity: O(N), Space complexity: worst O(N), average O(logN)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        inorder(res, root);
        return res;
    }

    public void inorder(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(list, node.left);
        list.add(node.val);
        inorder(list, node.right);
    }

    // Time complexity: O(N), Space complexity: O(N)
    public List<Integer> inorderTraversalWithIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || stack.size() > 0) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }

}
