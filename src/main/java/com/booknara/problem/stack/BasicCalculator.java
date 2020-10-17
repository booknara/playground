package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 224. Basic Calculator (Hard)
 * https://leetcode.com/problems/basic-calculator/
 */
public class BasicCalculator {
    // T:O(n), S:O(n)
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

    // T:O(n), S:O(n)
    public int calculate1(String s) {
        // input
        s = s.trim();
        return calc(s, 0).val;
    }

    public Pair calc(String s, int index) {
        int sign = 1;
        int num = 0;
        int lastIndex = index;
        Stack<Integer> stack = new Stack<>();
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                Pair p = calc(s, i + 1);
                num = p.val;
                i = p.index;
            } else if (c == ')') {
                lastIndex = i;
                break;
            } else {
                stack.push(sign * num);
                // +, -
                if (c == '+') sign = 1;
                else sign = -1;

                num = 0;
            }
        }

        // last sign handling
        stack.push(sign * num);
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return new Pair(res, lastIndex);
    }

    static class Pair {
        int val;
        int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
