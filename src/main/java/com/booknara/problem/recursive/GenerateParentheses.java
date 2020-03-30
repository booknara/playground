package com.booknara.problem.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses (Medium)
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
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
}
