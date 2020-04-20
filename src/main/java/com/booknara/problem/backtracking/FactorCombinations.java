package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 254. Factor Combinations (Medium)
 * https://leetcode.com/problems/factor-combinations/
 */
public class FactorCombinations {
    // O(sqrt(N)* log(sqrt(N))
    List<List<Integer>> res;
    public List<List<Integer>> getFactors(int n) {
        res = new ArrayList<>();
        if (n <= 3) {
            return res;
        }

        dfs(n, 2, (int) Math.sqrt(n), new LinkedList<>());
        return res;
    }

    private void dfs(int n, int start, int upper, LinkedList<Integer> list) {
        // base case
        if (n <= 1) {
            if (list.size() > 1) {
                // new result list
                List<Integer> ans = new ArrayList<>(list);
                res.add(ans);
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (i > upper) {
                // Optimization: i is supposed to be less or equal to square root value(Math.sqrt(n)))
                // to stop more recursive call and output the list in the base case;
                i = n;
            }

            if (n % i == 0) {
                list.addLast(i);
                dfs(n / i, i, (int) Math.sqrt(n / i), list);
                list.pollLast();
            }
        }
    }
}
