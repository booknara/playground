package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. Permutations II (Medium)
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
    // T:O(n!), S:(n!)
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        backtracking(nums, 0, res);

        return res;
    }

    public void backtracking(int[] nums, int idx, List<List<Integer>> res) {
        // base case
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n: nums) {
                list.add(n);
            }
            res.add(list);

            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            swap(nums, idx, i);
            backtracking(nums, idx + 1, res);
            swap(nums, idx, i);
        }
    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;


        Set<String> set = new HashSet<>();
        backtracking1(nums, 0, res, set);

        return res;
    }

    public void backtracking1(int[] nums, int idx, List<List<Integer>> res, Set<String> set) {
        // base case
        if (idx == nums.length) {
            StringBuilder builder = new StringBuilder();
            List<Integer> list = new ArrayList<>();
            for (int n: nums) {
                list.add(n);
                builder.append(n).append("-");
            }
            if (!set.contains(builder.toString())) {
                set.add(builder.toString());
                res.add(list);
            }

            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            backtracking1(nums, idx + 1, res, set);
            swap(nums, idx, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
