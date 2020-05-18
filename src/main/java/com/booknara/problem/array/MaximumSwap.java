package com.booknara.problem.array;

/**
 * 670. Maximum Swap (Medium)
 * https://leetcode.com/problems/maximum-swap/
 */
public class MaximumSwap {
    // T:O(n), S:(1)
    public int maximumSwap(int num) {
        if (num == 0) {
            return num;
        }

        char[] array = String.valueOf(num).toCharArray();
        int[] nums = new int[10];
        for (int i = 0; i < array.length; i++) {
            nums[array[i] - '0'] = i;
        }

        for (int i = 0; i < array.length; i++) {
            // only check the higher index number(e.g. 9->none, 8-> index of 9)
            for (int j = 9; j > array[i] - '0'; j--) {
                if (nums[j] > i) {
                    // swap i and j
                    //System.out.println("swap : " + i + ", " + j);
                    char temp = array[i];
                    array[i] = array[nums[j]];
                    array[nums[j]] = temp;
                    return Integer.parseInt(new String(array));
                }
            }
        }

        return num;
    }
}
