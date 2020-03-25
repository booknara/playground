package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. Combinations (Medium)
 * https://leetcode.com/problems/combinations/
 */
public class Combinations {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        this.res = new ArrayList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        backtracking(ans, 1, n, k);

        return res;
    }

    public void backtracking(LinkedList<Integer> list, int start, int n, int k) {
        if (k == 0) {
            res.add(new LinkedList<>(list));
            return;
        }

        // n - k + 1 : the count that only needs to iterate by updating k
        for (int i = start; i <= n - k + 1; i++) {
            list.addLast(i);
            backtracking(list, i + 1, n, k - 1);
            list.removeLast();
        }
    }
}
