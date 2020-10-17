package com.booknara.problem.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses (Medium)
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    // T, S:O(nth-Catalan number), roughly it's exponential complexity
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        dfs(res, n - 1, n, n * 2, "(");
        return res;
    }

    private void dfs(List<String> list, int open, int close, int max, String s) {
        if (s.length() == max) {
            list.add(new String(s));
            return;
        }

        if (open > 0) {
            dfs(list, open - 1, close, max, s + "(");
        }

        if (open < close && close > 0) {
            dfs(list, open, close - 1, max, s + ")");
        }
    }

    public List<String> generateParenthesis1(int n) {
        // input check
        List<String> res = new ArrayList<>();
        if (n == 0) return res;

        dfs(res, n, n, new StringBuilder());

        return res;
    }

    public void dfs(List<String> res, int open, int close, StringBuilder builder) {
        // base case
        if (open > close) return;   // tree pruning
        if (open < 0 || close < 0) return;

        if (open == 0 && close == 0) {
            res.add(builder.toString());
            return;
        }

        // open == close or open < close
        builder.append("(");
        dfs(res, open - 1, close, new StringBuilder(builder.toString()));
        builder.deleteCharAt(builder.length() - 1); // backtracking
        builder.append(")");
        dfs(res, open, close - 1, new StringBuilder(builder.toString()));
    }

    // T, S:O(nth-Catalan number), roughly it's exponential complexity
    public List<String> generateParenthesis2(int n) {
        // input check
        List<String> res = new ArrayList<>();
        if (n == 0) return res;

        dfs(0, 0, n, new StringBuilder(), res);
        return res;
    }

    public void dfs(int openCount, int closeCount, int n, StringBuilder builder, List<String> res) {
        // base case
        if (openCount > n || closeCount > n) return;
        if (openCount == n && closeCount == n) {
            res.add(builder.toString());
            return;
        }

        builder.append("(");    // open (
        dfs(openCount + 1, closeCount, n, builder, res);
        builder.deleteCharAt(builder.length() - 1);

        if (openCount > closeCount) {
            builder.append(")");    // close )
            dfs(openCount, closeCount + 1, n, builder, res);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
