package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets (Medium)
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        if (index > nums.length) {
            return;
        }

        res.add(new ArrayList<>(list));

        // backtracking
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    // Iterative without backtracking
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++) {
            int n = result.size();
            for(int j = 0; j < n; j++) {
                result.add(new ArrayList<>(result.get(j)));
                result.get(result.size() - 1).add(nums[i]);
            }
        }

        return result;
    }
}
