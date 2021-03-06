package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. Combination Sum (Medium)
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    // Backtracking, Time complexity - O(#candidates^target)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        // Better to remove
//        Arrays.sort(candidates);
//        if(candidates[0] > target) {
//            return res;
//        }

        dfs(candidates, 0, new LinkedList<>(), target, res);
        return res;
    }

    public void dfs(int[] candidates,
                    int index,
                    LinkedList<Integer> nums,
                    int remaining,
                    List<List<Integer>> res) {
        if (remaining < 0) return;
        if (remaining == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            nums.addLast(candidates[i]);
            dfs(candidates, i, nums, remaining - candidates[i], res);
            nums.removeLast();
        }
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        dfs(candidates, 0, new ArrayList<>(), target, res);
        return res;
    }

    public void dfs(int[] candidates,
                    int index,
                    List<Integer> nums,
                    int remaining,
                    List<List<Integer>> res) {
        if (remaining < 0) {
            return;
        }
        if (remaining == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>(nums);
            list.add(candidates[i]);
            dfs(candidates, i, list, remaining - candidates[i], res);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;

        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new LinkedList<>(), res);

        return res;
    }

    public void dfs(int[] candidates, int target, int index, int sum,
                    LinkedList<Integer> list, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (index == candidates.length) return;

        for (int i = index; i < candidates.length; i++) {

            if (sum + candidates[i] > target) continue;

            list.addLast(candidates[i]);
            dfs(candidates, target, i, sum + candidates[i], list, res);
            list.removeLast();
        }
    }
}
