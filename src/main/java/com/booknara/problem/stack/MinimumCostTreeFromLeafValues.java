package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 1130. Minimum Cost Tree From Leaf Values (Medium)
 * Given an array arr of positive integers, consider all binary trees such that:
 *
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
 * (Recall that a node is a leaf if and only if it has 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
 * Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.
 * It is guaranteed this sum fits into a 32-bit integer.
 *
 * Example 1:
 *
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.
 *
 *     24            24
 *    /  \          /  \
 *   12   4        6    8
 *  /  \               / \
 * 6    2             2   4
 */
public class MinimumCostTreeFromLeafValues {
    // Time: O(n), Space: O(n)
    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Monotonic stack
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int total = 0;
        for (int n: arr) {
            // System.out.println(n);
            while (stack.peek() != Integer.MAX_VALUE
                    && stack.peek() < n) {
                int smallest = stack.pop();
                if (stack.peek() > n) {
                    total += smallest * n;
                } else {
                    total += smallest * stack.peek();
                }
            }

            stack.push(n);
        }

        while (stack.peek() != Integer.MAX_VALUE) {
            int top = stack.pop();
            if (stack.peek() != Integer.MAX_VALUE) {
                total += stack.peek() * top;
            }
        }

        return total;
    }
}
