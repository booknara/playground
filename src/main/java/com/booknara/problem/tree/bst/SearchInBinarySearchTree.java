package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

/**
 * 700. Search in a Binary Search Tree (Easy)
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class SearchInBinarySearchTree {
    // T:O(h), S:(h)
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;

        if (val < root.val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}
