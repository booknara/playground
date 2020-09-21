package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses (Hard)
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    // T:O(n), S:O(n)
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.empty()) { // Edge case if stack is empty e.g. "))))))"
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    // T:O(n), S:O(n)
    public int longestValidParentheses1(String s) {
        // input check
        if (s == null || s.length() == 0) return 0;

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);     // edge case e.g. "()"
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                // ')' case
                // stack.peek() != -1 -> because of the init value (-1)
                if (stack.peek() != -1 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        // ")()(()"
        // "03"
        int last = s.length();
        while (!stack.isEmpty()) {
            int top = stack.pop();
            max = Math.max(max, last - top - 1);
            last = top;
        }

        return max;
    }
}
