package com.booknara.problem.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. Next Greater Element I (Easy)
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElement {
    // 05/09/2020 version, T:O(n + m)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // input check
        if (nums1 == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = nums2.length - 1; i >= 0; i--) {
            int n = nums2[i];
            // in case of initial setting or top value is smaller than input, then pop() because it's not answer
            while (stack.peek() != -1 && stack.peek() < n) {
                stack.pop();
            }

            int next = stack.peek();
            stack.push(n);
            map.put(n, next);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }

    // Using stack O(n + m)
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums2 == null || nums2.length == 0) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i: nums2) {
            if (stack.empty()) {
                stack.push(i);
                continue;
            }

            if (i > stack.peek()) {
                while (!stack.empty() && i > stack.peek()) {
                    map.put(stack.pop(), i);
                }
            }

            stack.push(i);
        }

        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
