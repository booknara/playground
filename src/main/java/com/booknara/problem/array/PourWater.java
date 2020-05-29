package com.booknara.problem.array;

/**
 * 755. Pour Water (Medium)
 * https://leetcode.com/problems/pour-water/
 */
public class PourWater {
    // T:O(n + V), S:O(1)
    public int[] pourWater(int[] heights, int V, int K) {
        if (heights == null || heights.length == 0 || V == 0) {
            return heights;
        }

        while (V-- > 0) {
            // find left index to fill
            int index = K;
            for (int i = K - 1; i >= 0; i--) {
                if (heights[i] > heights[index]) {
                    // No need to proceed because it's higher
                    break;
                }

                if (heights[i] < heights[index]) {
                    index = i;
                }
            }

            // if it's still K, then find right index to fill since there is no left index found
            if (index == K) {
                for (int i = K + 1; i < heights.length; i++) {
                    if (heights[i] > heights[index]) {
                        // No need to proceed because it's higher
                        break;
                    }

                    if (heights[i] < heights[index]) {
                        index = i;
                    }
                }
            }

            heights[index]++;
        }

        return heights;
    }
}
