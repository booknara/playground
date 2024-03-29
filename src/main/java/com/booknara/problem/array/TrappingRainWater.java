package com.booknara.problem.array;

/**
 * 42. Trapping Rain Water (Hard)
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    // Approach: DP -> Time complexity: O(n), Space complexity: O(n)
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }

        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }

        int total = 0;
        for (int i = 0; i < height.length; i++) {
            total += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return total;
    }

    // Approach: Two pointers -> Time complexity: O(n), Space complexity: O(1)
    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int leftMax = 0, rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int total = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    total += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    total += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return total;
    }
}
