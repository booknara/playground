package com.booknara.problem.tree.traverse;

import com.booknara.problem.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 173. Binary Search Tree Iterator (Medium)
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note:
 *
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * You may assume that next() call will always be valid, that is,
 * there will be at least a next smallest number in the BST when next() is called.
 */
public class BinarySearchTreeIterator {
    private Queue<Integer> queue = new LinkedList<>();

    // Using inorder traverse
    public BinarySearchTreeIterator(TreeNode root) {
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
