package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * Leet code: 938(Easy)
 * Given the root node of a binary search tree,
 * return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 *
 * Example 2:
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *
 * Note: The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 */
public class RangeSumOfBST {
    int sum = 0;
    // Recursive method. Time: O(n), Space: O(1)
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        if (L < root.val) {
            rangeSumBST(root.left, L, R);
        }

        if (R > root.val) {
            rangeSumBST(root.right, L, R);
        }

        return sum;
    }

    // Recursive method. Time: O(n), Space: O(h), height of BST
    public int rangeSumBSTIterative(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.val >= L && node.val <= R) {
                    sum += node.val;
                }

                if (L < node.val) {
                    stack.push(node.left);
                }

                if (R > node.val) {
                    stack.push(node.right);
                }
            }
        }

        return sum;
    }

}
