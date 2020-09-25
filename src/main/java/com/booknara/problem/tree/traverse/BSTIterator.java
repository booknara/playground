package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator (Medium)
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftNode(root);
    }

    public void pushLeftNode(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop();
        pushLeftNode(res.right);

        return res.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
