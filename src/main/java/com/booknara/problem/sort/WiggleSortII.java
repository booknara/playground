package com.booknara.problem.sort;

import java.util.Arrays;

/**
 * 324. Wiggle Sort II (Medium)
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class WiggleSortII {
    // T:O(nlogn), S:O(n)
    public void wiggleSort(int[] nums) {
        // https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java/81849
        // find median value
        // (1) elements smaller than the 'median' are put into the last even slots
        // (2) elements larger than the 'median' are put into the first odd slots
        // (3) the medians are put into the remaining slots.
    }
    // T:O(nlogn), S:O(n)
    public void wiggleSort1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int[] copy = nums.clone();
        Arrays.sort(copy);

        // fill nums array
        // odd element (the biggest - next - next)
        int idx = copy.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = copy[idx--];
        }
        // even element (next - next)
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = copy[idx--];
        }
    }
}
