package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II (Medium)
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
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
            if (i > index && nums[i - 1] == nums[i]) continue;
            list.add(nums[i]);
            dfs(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
