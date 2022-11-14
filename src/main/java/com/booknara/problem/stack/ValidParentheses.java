package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 20. Valid Parentheses (Easy)
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
  // T:O(n), S:O(n)
  public boolean isValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      // open case
      if ((c == '(' || c == '{' || c == '[')) {
        stack.push(c);
        continue;
      }

      // close case
      if (stack.isEmpty()) return false;
      char e = stack.pop();
      if ((e == '(') != (c == ')')) return false;
      if ((e == '{') != (c == '}')) return false;
      if ((e == '[') != (c == ']')) return false;
    }

    return stack.isEmpty();
  }

  // T:O(n), S:O(n)
  public boolean isValid1(String s) {
    // input check
    if (s == null || s.length() == 0) return true;

    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {

      // open bracket
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else if (c == ')' || c == '}' || c == ']') {
        if (stack.isEmpty()) return false;
        char pop = stack.pop();
        if ((c == ')' && pop == '(')
            || (c == '}' && pop == '{')
            || (c == ']' && pop == '[')) {
          continue;
        }

        return false;
      }
    }

    return stack.isEmpty();
  }

}
