package com.booknara.problem.tree.bst;

import com.booknara.problem.common.TreeNode;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST (Medium)
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInBST {
    // T:O(n), S:(h)
    public int kthSmallest(TreeNode root, int k) {
        // Given problem description, root can't be null (1 ≤ k ≤ BST's total elements)
        // Inorder iterative traverse means to retrieve from the smallest to the biggest number.
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int i = 1;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            // System.out.println(cur.val);
            if (i == k) return cur.val;
            i++;
            cur = cur.right;
        }

        return -1;
    }
}
