package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leet code: 46. Permutations(Medium)
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return output;
        }

        List<Integer> ans = new ArrayList<>();
        for (int n: nums) {
            ans.add(n);
        }

        int len = nums.length;
        dfs(ans, len, 0, output);

        return output;
    }

    public void dfs(List<Integer> source, int len, int first, List<List<Integer>> output) {
        if (first == len) {
            output.add(new ArrayList<>(source));
            return;
        }
        for (int i = first; i < len; i++) {
            Collections.swap(source, first, i);
            dfs(source, len, first + 1, output);
            Collections.swap(source, first, i);
        }
    }

}
