package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 503. Next Greater Element II (Medium)
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class NextGreaterElementII {
    // T:O(n), S:O(n)
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] res = new int[nums.length];
        // store index instead of value
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int idx = i % nums.length;
            int v = nums[idx];
            while (stack.peek() != -1 && nums[stack.peek()] <= v) {
                stack.pop();
            }

            if (stack.peek() == -1) {
                res[idx] = -1;
            } else {
                res[idx] = nums[stack.peek()];
            }

            stack.push(idx);
        }

        return res;
    }
}
