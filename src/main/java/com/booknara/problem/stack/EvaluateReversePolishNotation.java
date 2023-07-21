package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation (Medium)
 * https://leetcode.com/problems/evaluate-reverse-polish-notation
 */
public class EvaluateReversePolishNotation {
  // T:O(n), S:O(n)
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String s: tokens) {
      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
        // operators
        int num2 = stack.pop();
        int num1 = stack.pop();
        switch (s) {
          case "+":
            stack.push(num1 + num2);
            break;
          case "-":
            stack.push(num1 - num2);
            break;
          case "*":
            stack.push(num1 * num2);
            break;
          case "/":
            stack.push(num1 / num2);
            break;
        }
      } else {
        // numbers
        stack.push(Integer.parseInt(s));
      }
    }

    return stack.pop();
  }
}
