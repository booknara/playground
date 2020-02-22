package com.booknara.problem.twopointers;

/**
 * Leet code: 167. Two Sum II - Input array is sorted (Easy)
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0 || numbers.length == 1) {
            return null;
        }

        int i = 0, j = numbers.length - 1;
        while (i < j) {
            //System.out.println(numbers[i]);
            if (numbers[i] + numbers[j]  == target) {
                return new int[] {i + 1, j + 1};
            }

            if (numbers[i] + numbers[j]  < target) {
                i++;
            } else {
                j--;
            }
        }

        return null;
    }
}
