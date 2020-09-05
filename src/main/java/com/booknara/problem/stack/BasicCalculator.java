package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 224. Basic Calculator (Hard)
 * https://leetcode.com/problems/basic-calculator/
 */
public class BasicCalculator {
    // T:O(n), S:O(2m, m = the number of '(')
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int num = 0;
        int sign = 1; // -1: negative, 1: positive
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result = result + sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result = result + sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                // push result, sign
                stack.push(result);
                stack.push(sign);
                num = 0;
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = result + sign * num;
                // push sign, result
                sign = stack.pop();
                int prev = stack.pop();
                result = prev + sign * result;
                num = 0;
                sign = 1;
            }
        }

        return result + sign * num;
    }
}
