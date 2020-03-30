package com.booknara.problem.tree;

import java.util.Stack;

/**
 * 255. Verify Preorder Sequence in Binary Search Tree (Medium)
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 */
public class VerifyPreorderSequenceInBST {
    // Without space
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }

        int low = Integer.MIN_VALUE;
        int top = -1;
        for (int p: preorder) {
            if (p < low) {
                return false;
            }

            while (top >= 0 && preorder[top] < p) {
                low = preorder[top--];
            }

            preorder[++top] = p;
        }

        return true;
    }
    // With space
    public boolean verifyPreorder1(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }

        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int p: preorder) {
            if (p < low) {
                return false;
            }

            while (!stack.empty() && stack.peek() < p) {
                low = stack.pop();
            }
            stack.push(p);
        }

        return true;
    }
}
