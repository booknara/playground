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
        // input check
        if (nums == null || nums.length < 3) return res;

        // sort (ascending)
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                // prevent getting duplicated triplets
                continue;
            }
            int selected = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = selected + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(selected, nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r - 1] == nums[r]) r--;

                    l++;
                    r--;
                } else if (sum < 0) {
                    // need to increase
                    l++;
                } else {
                    // need to decrease
                    r--;
                }
            }
        }

        return res;
    }
}
