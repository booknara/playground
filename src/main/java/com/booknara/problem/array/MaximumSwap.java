package com.booknara.problem.array;

/**
 * 670. Maximum Swap (Medium)
 * https://leetcode.com/problems/maximum-swap/
 */
public class MaximumSwap {
    // T:O(n), S:(1)
    public int maximumSwap(int num) {
        if (num < 10) return num;

        char[] array = String.valueOf(num).toCharArray();
        int[] nums = new int[10]; // 0 ~ 9
        for (int i = 0; i < array.length; i++) {
            nums[array[i] - '0'] = i;
        }

        // check the number from 0 index to find bigger number
        for (int i = 0; i < array.length; i++) {
            // 9 <= number > array[i] - '0'
            for (int j = 9; j > array[i] - '0'; j--) {
                if (nums[j] > i) {
                    //System.out.println(j + "," + (array[i] - '0'));
                    swap(array, nums[j], i);
                    return Integer.parseInt(new String(array));
                }
            }
        }

        // no swap
        return num;
    }

    public void swap(char[] array, int i, int j) {
        char c = array[i];
        array[i] = array[j];
        array[j] = c;
    }
}
