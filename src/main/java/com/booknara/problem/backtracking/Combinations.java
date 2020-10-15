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

    public List<List<Integer>> combine1(int n, int k) {
        // input check
        List<List<Integer>> res = new ArrayList<>();
        if (n == k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) {
                list.add(i);
            }
            res.add(list);
            return res;
        }

        backtracking(1, n, k, new LinkedList<>(), res);
        return res;
    }

    public void backtracking(int index, int n, int k,
                             LinkedList<Integer> list, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index > n) return;

        for (int i = index; i <= n - k + 1; i++) {
            list.addLast(i);
            backtracking(i + 1, n, k - 1, list, res);
            list.removeLast();
        }
    }
}
/**
 Input: n = 4, k = 2

 1,2,3,4 (1 ~ n), k = 2 the number of elements

 Output:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */