package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 1130. Minimum Cost Tree From Leaf Values (Medium)
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
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
