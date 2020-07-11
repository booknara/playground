package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II (Medium)
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {
    // T:O(n * 2^n), S:O(n * 2^n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> res) {
        if (start > nums.length) {
            return;
        }

        res.add(new ArrayList<>(list));

        // backtracking
        for (int i = start; i < nums.length; i++) {
            // Key point: if i == start, proceed, but if i > start and same value with the previous, skip
            if (i > start && nums[i - 1] == nums[i]) continue;
            list.add(nums[i]);
            dfs(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
