package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. Subsets (Medium)
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {
    // T:O(n * 2^n), S:O(n * 2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>()); // empty array
        backtracking(nums, 0, new LinkedList<>(), res);
        return res;
    }

    public void backtracking(int[] nums,
                             int start,
                             LinkedList<Integer> list,
                             List<List<Integer>> res) {
        if (start >= nums.length) return;

        for (int i = start; i < nums.length; i++) {
            list.addLast(nums[i]);
            res.add(new ArrayList<>(list));
            backtracking(nums, i + 1, list, res);
            list.removeLast();
        }
    }

    // [1,2,3]
    // 1 -> [], [1] without 1, with 1
    // 2 -> [], [1], [2], [1,2] without 2, with 2
    // 3 -> [], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3] without 3, with 3
    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>()); // empty array
        for (int n: nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newList = new ArrayList<>(res.get(i));    // without n
                newList.add(n); // with n
                res.add(newList);
            }
        }

        return res;
    }

    public List<List<Integer>> subsets1(int[] nums) {
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
    public List<List<Integer>> subsets2(int[] nums) {
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
