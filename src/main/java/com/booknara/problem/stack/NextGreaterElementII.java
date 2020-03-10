package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 503. Next Greater Element II (Medium)
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return res;
        }

        Stack<Integer> stack = new Stack<>();
        // two loops
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            if (stack.empty()) {
                stack.push(i);
                res[i % nums.length] = -1;
                continue;
            }

            while (!stack.empty()) {
                int prev = stack.peek();
                if (nums[prev % nums.length] > nums[i % nums.length]) {
                    res[i % nums.length] = nums[prev % nums.length];
                    break;
                }

                if (!stack.empty()) {
                    stack.pop();
                } else {
                    res[i % nums.length] = -1;
                }
            }

            if (stack.empty()) {
                res[i % nums.length] = -1;
            }
            stack.push(i % nums.length);
        }

        return res;
    }
}
