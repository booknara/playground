package com.booknara.problem.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. Next Greater Element I (Easy)
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElement {
    // Using stack O(n + m)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
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

    // Using HashMap
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums2 == null || nums2.length == 0) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            int idx = map.get(nums1[i]);
            for (int j = idx + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }

        return res;
    }
}
