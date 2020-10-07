package com.booknara.problem.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 403. Frog Jump (Hard)
 * https://leetcode.com/problems/frog-jump/
 */
public class FrogJump {
    // T:O(n^2), S:O(n^2)
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> memo = new HashMap<>();
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            memo.put(stones[i], new HashSet<>());
        }
        memo.get(0).add(0); // init

        for (int i = 0; i < n; i++) {
            for (int k: memo.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && memo.containsKey(stones[i] + step)) {
                        memo.get(stones[i] + step).add(step);
                    }
                }
            }
        }

        return !memo.get(stones[n - 1]).isEmpty();
    }
}
