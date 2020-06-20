package com.booknara.problem.math;

/**
 * 60. Permutation Sequence (Medium)
 * https://leetcode.com/problems/permutation-sequence/
 */
public class PermutationSequence {
    // T:O(n!), S:O(1)
    public String getPermutation(int n, int k) {
        if (n == 1) return "1";

        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }

        if (k == 1) {
            // return original value
            return getStringNumber(num);
        }

        for (int i = 1; i < k; i++) {
            nextPermutation(num);
        }

        return getStringNumber(num);
    }

    public String getStringNumber(int[] num) {
        StringBuilder builder = new StringBuilder();
        for (int i: num) {
            builder.append(i);
        }

        //System.out.println(builder.toString());
        return builder.toString();
    }

    public void nextPermutation(int[] nums) {
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

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}