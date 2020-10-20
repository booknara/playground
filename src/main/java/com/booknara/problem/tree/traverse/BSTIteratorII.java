package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * 1586. Binary Search Tree Iterator II (Medium)
 * https://leetcode.com/problems/binary-search-tree-iterator-ii/
 */
public class BSTIteratorII {
    TreeNode dummy = new TreeNode(-1);
    TreeNode cur = dummy;
    Stack<TreeNode> stack;

    public BSTIteratorII(TreeNode root) {
        stack = new Stack<>();
        pushLeftNode(root);
    }

    public void pushLeftNode(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !(cur.right == null && stack.isEmpty());
    }

    public int next() {
        // initially cur = dummy, cur.right = null
        if (cur.right == null) {
            TreeNode next = stack.pop();
            pushLeftNode(next.right);

            next.right = null;

            next.left = cur;
            cur.right = next;
        }

        cur = cur.right;
        return cur.val;
    }

    public boolean hasPrev() {
        return (cur != dummy && cur.left != dummy);
    }

    public int prev() {
        cur = cur.left;
        return cur.val;
    }
}
