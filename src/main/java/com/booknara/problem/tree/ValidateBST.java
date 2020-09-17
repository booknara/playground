package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree (Medium)
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBST {
    // T:O(n), S:O(h)
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    public boolean isBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (min != null && min >= node.val) return false;
        if (max != null && max <= node.val) return false;

        if (!isBST(node.left, min, node.val)) return false;
        if (!isBST(node.right, node.val, max)) return false;

        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;

        // preorder traverse (ascending order)
        Integer num = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            //System.out.println(cur.val);
            if (num == null) {
                num = cur.val;
            } else {
                if (num >= cur.val) return false;
                num = cur.val;
            }
            cur = cur.right;
        }

        return true;
    }

    Integer num = null;
    boolean valid = true;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;

        preorder(root);

        return valid;
    }

    public void preorder(TreeNode node) {
        if (node == null) return;

        preorder(node.left);
        if (num == null) {
            num = node.val;
        } else {
            if (num >= node.val) {
                valid = false;
            } else {
                num = node.val;
            }
        }
        preorder(node.right);
    }

}
