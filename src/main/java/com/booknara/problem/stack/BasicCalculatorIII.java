package com.booknara.problem.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 772. Basic Calculator III (Hard)
 * https://leetcode.com/problems/basic-calculator-iii/
 */
public class BasicCalculatorIII {
    // T:O(n), S:O(n)
    public int calculate(String s) {
        // input check
        if (s == null || s.length() == 0) return 0;
        Queue<Character> q = new LinkedList<>();
        for (char c: s.toCharArray()) {
            if (c == ' ') continue;
            q.offer(c);
        }
        q.offer('+');   // for the last number
        return calc(q);
    }

    public int calc(Queue<Character> q) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                num = calc(q);
            } else {
                // +, -, *, /, )
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
                if (c == ')') {
                    break;
                }
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
/**
 input characters: (, ), +, -, *, /, non-negative integers, white space

 "2*(5+5*2)/3+(6/2+8)"
 "2*(?)/3+(?)"

 (5+5*2)
 */