package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 173. Binary Search Tree Iterator (Medium)
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {
    private Queue<Integer> queue = new LinkedList<>();

    // Using inorder traverse
    public BSTIterator(TreeNode root) {
        traverse(root);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        traverse(node.left);
        queue.offer(node.val);
        traverse(node.right);
    }
}
