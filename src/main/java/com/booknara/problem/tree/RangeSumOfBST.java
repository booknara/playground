package com.booknara.problem.tree;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * 938. Range Sum of BST (Easy)
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {
    int sum = 0;
    // T:O(n), S:O(h)
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return sum;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node == null) return;

        // inclusive
        if (node.val >= L && node.val <= R) {
            //System.out.println(node.val);
            sum += node.val;
        }

        if (L < node.val) dfs(node.left, L, R);
        if (node.val < R) dfs(node.right, L, R);
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
