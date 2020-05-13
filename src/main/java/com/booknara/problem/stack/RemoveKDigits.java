package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 402. Remove K Digits (Medium)
 * https://leetcode.com/problems/remove-k-digits/
 */
public class RemoveKDigits {
    // T:O(n), S:O(n)
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || num.length() == k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            // check monotonic stack(increasing)
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // in case of remaining k, remove the number of k from the stack top
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        builder.reverse();

        // remove any leading zero number
        while (builder.length() > 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }
}
