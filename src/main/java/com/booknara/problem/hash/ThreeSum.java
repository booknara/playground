package com.booknara.problem.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int j = i + 1, k = nums.length - 1;

                int sum = 0 - nums[i];
                while (j < k) {
                    if (sum == nums[j] + nums[k]) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j+1]) j++;
                        while (j < k && nums[k] == nums[k-1]) k--;
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < sum) {
                        j++;
                    } else {
                        k--;
                    }
                }

            }
        }

        return ans;
    }
}
