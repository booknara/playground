package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations (Medium)
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    // T:O(n!), S:(n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        backtracking(nums, 0, res);
        return res;
    }

    public void backtracking(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n: nums) {
                list.add(n);
            }
            res.add(list);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            backtracking(nums, idx + 1, res);
            swap(nums, idx, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
