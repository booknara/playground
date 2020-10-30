package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 465. Optimal Account Balancing (Hard)
 * https://leetcode.com/problems/optimal-account-balancing/
 */
public class OptimalAccountBalancing {
    // T:O(n*2^n), S:O(2^n)
    public int minTransfers(int[][] transactions) {
        // input check
        if (transactions == null || transactions.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] tx: transactions) {
            // +
            map.put(tx[0], map.getOrDefault(tx[0], 0) + tx[2]);
            // -
            map.put(tx[1], map.getOrDefault(tx[1], 0) - tx[2]);
        }

        List<Integer> list = new ArrayList<>();
        for (int v: map.values()) {
            if (v != 0) {
                list.add(v);
            }
        }

        if (list.size() == 0) return 0;

        return backtracking(0, list);
    }

    public int backtracking(int index, List<Integer> list) {
        // base case
        if (index == list.size()) return 0;

        int current = list.get(index);
        if (current == 0) {
            return backtracking(index + 1, list);
        }

        int min = Integer.MAX_VALUE;

        // for the current balance, try to find the minimum number of transactions using the others
        for (int i = index + 1; i < list.size(); i++) {
            int next = list.get(i);
            if (current * next < 0) {
                list.set(i, current + next);
                // one is +/-, the other is -/+
                min = Math.min(min, 1 + backtracking(index + 1, list));
                list.set(i, next);

                // pruning
                if (current + next == 0) break;
            }
        }

        return min;
    }
}
