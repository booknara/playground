package com.booknara.problem.math;

/**
 * 1217. Minimum Cost to Move Chips to The Same Position (Easy)
 * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 */
public class MinimumCostToMoveChipsToTheSamePosition {
    // T:O(n), S:O(1)
    public int minCostToMoveChips(int[] position) {
        // input check
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return Math.min(even, odd);
    }
}
