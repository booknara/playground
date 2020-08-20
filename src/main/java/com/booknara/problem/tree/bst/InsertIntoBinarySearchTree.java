package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

/**
 * 701. Insert into a Binary Search Tree (Medium)
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoBinarySearchTree {
    // T:O(n), S:(n)
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        insert(root, val);
        return root;
    }

    public void insert(TreeNode node, int val) {
        // base case
        if (node == null) {
            return;
        }

        //System.out.println(node.val);
        if (node.val < val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                insert(node.right, val);
            }
        } else {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                insert(node.left, val);
            }
        }
    }
}
