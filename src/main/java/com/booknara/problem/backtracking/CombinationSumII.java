package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. Combination Sum II (Medium)
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    // T:O(2^n), S:O(2^n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        List<Integer> nums = new ArrayList<>();
        dfs(candidates, 0, target, nums, res);
        return res;
    }

    private void dfs(int[] candidates,
                     int index,
                     int remaining,
                     List<Integer> nums,
                     List<List<Integer>> res) {
        // To prune the branch, we assume all the candidate numbers are positive
        if (remaining < 0) return;

        if (remaining == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // i > index => key point to avoid duplicates
            if (i > index && candidates[i - 1] == candidates[i]) {
                continue;
            }

            // Optimization
            if (candidates[i] > remaining) continue;

            nums.add(candidates[i]);
            dfs(candidates, i + 1, remaining - candidates[i], nums, res);
            nums.remove(nums.size() - 1);
        }
    }

    // T:O(2^n), S:O(2^n)
    public List<List<Integer>> combinationSum21(int[] candidates, int target) {
        // input check
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;

        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, new LinkedList<>(), res);
        return res;
    }

    public void helper(int[] candidates, int target, int index, int sum,
                       LinkedList<Integer> candidate, List<List<Integer>> res) {
        // base case
        if (sum == target) {
            res.add(new ArrayList<>(candidate));
            return;
        }

        if (index == candidates.length) return;

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates [i - 1] == candidates[i]) continue;

            if (sum + candidates[i] > target) return;

            candidate.addLast(candidates[i]);
            helper(candidates, target, i + 1, sum + candidates[i], candidate, res);
            candidate.removeLast();
        }
    }
}
