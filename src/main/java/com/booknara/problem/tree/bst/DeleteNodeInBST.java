package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

/**
 * 450. Delete Node in a BST (Medium)
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeInBST {
    // T:O(logn), S:O(1)
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        PairNode pair = findNode(root, key);
        if (pair == null) {
            // not found
            return root;
        }

        // Leaf node found
        if (pair.node.left == null && pair.node.right == null) {
            // case 1: root and leaf node
            if (pair.node == root) {
                root = null;
                return root;
            }

            // case 2: leaf node
            if (pair.parent.left == pair.node) {
                pair.parent.left = null;
            } else {
                pair.parent.right = null;
            }

            return root;
        }

        // left child is null
        if (pair.node.left == null) {
            // special case (root node found)
            if (pair.node == root) {
                root = root.right;
                return root;
            }

            if (pair.parent.left == pair.node) {
                pair.parent.left = pair.node.right;
            } else {
                pair.parent.right = pair.node.right;
            }

            return root;
        }

        // right child is null
        if (pair.node.right == null) {
            // special case (root node found)
            if (pair.node == root) {
                root = root.left;
                return root;
            }

            if (pair.parent.left == pair.node) {
                pair.parent.left = pair.node.left;
            } else {
                pair.parent.right = pair.node.left;
            }

            return root;
        }

        // both child is not null
        // find successor
        TreeNode succ = pair.node.right;
        TreeNode succParent = pair.node;
        while (succ.left != null) {
            succParent = succ;
            succ = succ.left;
        }

        pair.node.val = succ.val;
        if (succParent.left == succ) {
            // succParent is on the left path and assign bigger value
            succParent.left = succ.right;
        } else {
            // in case that the initial succ doesn't have left child and assign bigger value
            succParent.right = succ.right;
        }

        return root;
    }

    public PairNode findNode(TreeNode node, int key) {
        TreeNode parent = null;
        TreeNode cur = node;
        while (cur != null) {
            if (cur.val == key) {
                //System.out.println("found");
                return new PairNode(parent, cur);
            }

            parent = cur;
            if (key < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return null;
    }

    static class PairNode {
        TreeNode parent;
        TreeNode node;

        PairNode(TreeNode parent, TreeNode node) {
            this.parent = parent;
            this.node = node;
        }
    }
}
