package com.booknara.problem.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum (Medium)
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    // T:O(n^2), S:O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // input check,
        if (nums.length < 3) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue; // preventing the duplicated triplets, [0,0,0,0]

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (l != i + 1 && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }

                int sum = nums[l] + nums[r];
                if (nums[i] + sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (nums[i] + sum < 0) {
                    l++;    // need to increase
                } else {
                    r--;    // need to decrease
                }
            }
        }

        return res;
    }

    // T:O(n^2), S:O(1)
    public List<List<Integer>> threeSum1(int[] nums) {
        // input check
        List<List<Integer>> res = new ArrayList<>();

        // required at least 3 elements
        if (nums == null || nums.length < 3) return res;

        // ascending
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int pivot = nums[i];
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) continue; // avoid the duplicated triplets

            int l = i + 1, r = n - 1;
            while (l < r) {
                if (pivot + nums[l] + nums[r] == 0) {
                    res.add(Arrays.asList(pivot, nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                    while (l < r && nums[r - 1] == nums[r]) r--;
                    r--;
                } else if (pivot + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
}
