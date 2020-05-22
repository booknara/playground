package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 907. Sum of Subarray Minimums (Medium)
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 */
public class SumOfSubarrayMinimums {
    // T:O(n), S:O(1)
    public int sumSubarrayMins(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        final int MOD = 1_000_000_000 + 7;
        // Monotonic stack(ascending), store index
        Stack<Integer> stack = new Stack<>();
        int[] prev = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? - 1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        // Monotonic stack(ascending)
        int[] next = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] < A[stack.peek()]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? A.length : stack.peek();
            stack.push(i);
        }

        long res = 0;
        for (int i = 0; i < A.length; i++) {
            res += A[i] * (i - prev[i]) * (next[i] - i);
            res %= MOD;
        }

        return (int) res;
    }
}
