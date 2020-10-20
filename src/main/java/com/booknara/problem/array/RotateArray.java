package com.booknara.problem.array;

import java.util.LinkedList;

/**
 * 189. Rotate Array (Easy)
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {
    // T:O(n), S:O(1)
    public void rotate(int[] nums, int k) {
        // input check
        k = k % nums.length;
        if (k == 0) return;

        int n = nums.length;
        // Intuition -> n-k th item will be at the front and next value to n-k th will take next place
        // there are three times to reverse
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    /**
     Intuition -> n-k th item will be at the front and next value to n-k th will take next place
     [1,2,3,4,   5,6,7] -> [5,6,7,1,2,3,4] after 3 steps
     there are two parts
     0 ~ (n - k - 1), (n - k) ~ (n - 1)
     reverse each part
     [1,2,3,4,5,6,7] -> [4,3,2,1,7,6,5]
     reverse the entire array
     [4,3,2,1,7,6,5] -> [5,6,7,1,2,3,4]
     */

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

    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;

        int n = nums.length;
        int[] res = new int[n];
        k = k % nums.length;
        for (int i = 0; i < n; i++) {
            int newIdx = (i + k) % n;
            res[newIdx] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }

}
