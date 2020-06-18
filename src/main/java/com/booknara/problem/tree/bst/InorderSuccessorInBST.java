package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * 285. Inorder Successor in BST (Medium)
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        // inorder traverse
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean found = false;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (found) {
                    return cur;
                }

                if (p == cur) {
                    found = true;
                }
                cur = cur.right;
            }
        }

        return null;
    }
}
