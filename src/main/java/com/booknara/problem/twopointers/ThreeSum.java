package com.booknara.problem.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leet code: 15. 3Sum (Medium)
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        // a + b + c = 0 -> a + b = -c
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            // left = i + 1 for getting rid of duplicate triplets
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // to remove duplicate triplets
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;

                    l++;
                    r--;
                } else if (nums[l] + nums[r] < -nums[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
}
