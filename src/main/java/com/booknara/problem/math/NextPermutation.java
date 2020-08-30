package com.booknara.problem.math;

import java.util.Arrays;

/**
 * 31. Next Permutation (Medium)
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    //T:O(n), S:O(1)
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int m = nums.length;
        int desIdx = -1;
        for (int i = m - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                desIdx = i;
                break;
            }
        }

        // the max number
        if (desIdx == -1) {
            int l = 0, r = m - 1;
            while (l < r) {
                swap(nums, l, r);
                l++;
                r--;
            }
            return;
        }

        // found desIdx
        for (int i = m - 1; i > desIdx; i--) {
            if (nums[i] > nums[desIdx]) {
                swap(nums, desIdx, i);
                break;
            }
        }

        int l = desIdx + 1, r = m - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    /**
     123 -> 132
     231 -> 312

     231 -> find decreasing number (2) and replace(swap) the number with the next bigger number after that
     swap the numbers between the index after the decreasing number and the last index
     321 -> replace 3 (before 2)

     5987654 -> 6 987 5 54
     6455789
     */
    public void nextPermutation1(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int inverse = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                continue;
            }

            inverse = i;

            int nextBig = 0;
            for (int j = nums.length - 1; j > inverse; j--) {
                if (nums[inverse] < nums[j]) {
                    nextBig = j;
                    break;
                }
            }

            // swap inverse and nextBig
            swap(nums, inverse, nextBig);
            break;
        }

        // reverse (all the array elements(54321->12345) or a part of elements(1254->1425))
        int l = inverse + 1, r = nums.length - 1;
        while (l <= r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    public void nextPermutation2(int[] nums) {
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
    }
}
