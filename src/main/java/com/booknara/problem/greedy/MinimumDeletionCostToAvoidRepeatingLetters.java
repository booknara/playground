package com.booknara.problem.greedy;

/**
 * 1578. Minimum Deletion Cost to Avoid Repeating Letters (Medium)
 * https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 */
public class MinimumDeletionCostToAvoidRepeatingLetters {
    // T:O(n), S:O(1)
    // The main idea is to add all the values except for the max cost
    public int minCost(String s, int[] cost) {
        // input check
        if (s == null || s.length() <= 1) return 0;

        int res = 0;
        int maxCost = cost[0];
        int c = s.charAt(0);
        for (int i = 1; i < cost.length; i++) {
            // two caes
            if (c != s.charAt(i)) { // not repeating character
                c = s.charAt(i);
                maxCost = cost[i];
            } else {
                // repeating character
                if (maxCost < cost[i]) {
                    res += maxCost;
                    maxCost = cost[i];
                } else {
                    res += cost[i];
                }
            }
        }

        return res;
    }
}
