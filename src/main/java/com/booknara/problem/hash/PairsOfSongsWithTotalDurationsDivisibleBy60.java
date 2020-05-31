package com.booknara.problem.hash;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60 (Easy)
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    // T:O(n), S:O(1)
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        if (time == null || time.length == 0) {
            return res;
        }

        int[] bucket = new int[60];
        for (int t: time) {
            // edge case: [60, 60, 60], 60 - t % 60 = 60, which is wrong
            int rest = (60 - t % 60) % 60;
            res += bucket[rest];

            bucket[t % 60]++;
        }

        return res;
    }
}
