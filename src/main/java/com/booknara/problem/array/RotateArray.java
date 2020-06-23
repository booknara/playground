package com.booknara.problem.array;

import java.util.LinkedList;

/**
 * 189. Rotate Array (Easy)
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {
    // input: integer array, k steps
    // output: nums
    // T:O(n), S:O(1)
    public void rotate(int[] nums, int k) {
        // input check: 1<= nums.length <= 2 * 10^4
        // k >= 0
        if (k == 0) return;

        int n = nums.length;
        k = k % n;
        // 0 ~ (n - k - 1), (n - k) ~ (n - 1)
        // reverse each part
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        // reverse the entire array
        reverse(nums, 0, n - 1);
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
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
    // [1,2,3,4,5,6,7] -> [5,6,7,1,2,3,4] after 3 steps
    // there are two parts
    // 0 ~ (n - k - 1), (n - k) ~ (n - 1)
    // reverse each part
    // [1,2,3,4,5,6,7] -> [4,3,2,1,7,6,5]
    // reverse the entire array
    // [4,3,2,1,7,6,5] -> [5,6,7,1,2,3,4]

    // T:O(n), S:O(n)
    public void rotate1(int[] nums, int k) {
        // input check: 1<= nums.length <= 2 * 10^4
        // k >= 0
        if (k == 0) return;

        LinkedList<Integer> list = new LinkedList<>();
        for (int n: nums) {
            list.addLast(n);
        }

        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int n = list.removeLast();
            list.addFirst(n);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.removeFirst();
        }
    }
}
