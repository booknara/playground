package com.booknara.problem.string;

/**
 * 678. Valid Parenthesis String (Medium)
 * https://leetcode.com/problems/valid-parenthesis-string/
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        // count low and high boundary
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            // '(' vs ')', '*'
            if (c == '(') {
                lo += 1;
            } else {
                lo += -1;
            }

            // '(', '*' vs ')'
            if (c != ')') {
                hi += 1;
            } else {
                hi -= 1;
            }
            // too many ')', invalid
            if (hi < 0) return false;
            // low boundary can't be negative
            lo = Math.max(lo, 0);
        }

        return lo == 0;
    }

    // Too slow, O(3^n), 3 : the three branch cases of '*' character, n : the length of string
    public boolean checkValidString1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        return dfs (s, 0, 0);
    }

    private boolean dfs(String s, int idx, int num) {
        if (num < 0) return false;  // pruning
        if (s.length() == idx) {
            // System.out.println("exit");
            return num == 0;
        }

        char c = s.charAt(idx);
        boolean symbol = false;
        if (c == '(') {
            symbol = dfs(s, idx + 1, num + 1);
        } else if (c == ')') {
            symbol = dfs(s, idx + 1, num - 1);
        }

        boolean wild1 = false, wild2 = false, wild3 = false;
        if (c == '*') {
            wild1 = dfs(s, idx + 1, num + 1);
            wild2 = dfs(s, idx + 1, num);
            wild3 = dfs(s, idx + 1, num - 1);
        }

        return symbol || wild1 || wild2 || wild3;
    }
}
