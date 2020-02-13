package com.booknara.problem.array;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int drop = -1;

        for (int i = nums.length - 1; i > 0; i--) {
            //System.out.print(nums[i]);
            if (nums[i - 1] < nums[i]) {
                drop = i - 1;
                break;
            }
        }

        if (drop == -1) {
            // Descending order
            Arrays.sort(nums);
            return;
        }

        int next = Integer.MAX_VALUE;
        int nextId = 0;
        for (int i = nums.length - 1; i > drop; i--) {
            if (nums[i] > nums[drop] && nums[i] < next) {
                next = nums[i];
                nextId = i;
            }
        }

        //System.out.println(nextId);
        swap(nums, drop, nextId);
        Arrays.sort(nums, drop + 1, nums.length);

        return;
    }

    public void nextPermutationSinglePath(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
