package com.booknara.problem.array;

public class FirstMissingPositive {
    // Time: O(N), N: the length of input array, Space: O(1)
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < 1) {
                nums[j] = Math.abs(nums[j]) + nums.length + 1;
            }
        }
        int i = 0;
        while (i < nums.length) {
            if (i == nums[i] - 1
                    || (i != 0 && nums[i] == nums[i - 1])) {
                i++;
            } else if (nums[i] >= 1
                    && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        int ans = nums[nums.length - 1] + 1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                ans = k + 1;
                break;
            }
        }

        return ans;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
