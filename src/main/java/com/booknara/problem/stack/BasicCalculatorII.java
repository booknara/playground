package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 227. Basic Calculator II (Medium)
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculatorII {
    // T:O(n), S:O(n)
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                // In case of symbols and last element
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }
        }

        int total = 0;
        for (Integer i: stack) {
            total += i;
        }

        return total;
    }

    // T:O(n), S:O(n)
    public int calculate1(String s) {
        // input check
        if (s == null || s.length() == 0) return 0;

        // Input: "3+2*2"
        // Output: 7
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        s = s.trim();
        char sign = '+';   // 0:+, 1:-, 2:*. 3:/
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                num *= 10;
                num += c - '0';
            }

            // for the last number (i == s.length() - 1)
            if (!Character.isDigit(c) || i == s.length() - 1) {
                // symbol here
                // there are two way
                if (sign == '+' || sign == '-') {
                    // add stack
                    stack.push(sign == '+' ? num : -num); // [3,+2]
                } else {
                    // calculate
                    int prev = stack.pop();
                    stack.push(sign == '*' ? prev * num : prev / num);
                }

                num = 0;
                sign = c;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    // T:O(n), S:O(n)
    public int calculate2(String s) {
        // input check
        if (s == null || s.length() == 0) return 0;

        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';    // 1: +, -1: -
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;

            // three cases, number, +-, */
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                // sign
                if (sign == '+' || sign == '-') {
                    if (sign == '+') stack.push(num);
                    else stack.push(-num);
                } else {
                    // *, /
                    int val;
                    if (sign == '*') val = stack.pop() * num;
                    else  val = stack.pop() / num;
                    stack.push(val);
                }

                sign = c;
                num = 0;
            }
        }

        // last sign handling
        if (sign == '+' || sign == '-') {
            if (sign == '+') stack.push(num);
            else stack.push(-num);
        } else {
            // *, /
            int val;
            if (sign == '*') val = stack.pop() * num;
            else  val = stack.pop() / num;
            stack.push(val);
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
