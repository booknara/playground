package com.booknara.problem.dp;

import java.util.Arrays;

/**
 * 935. Knight Dialer (Medium)
 * https://leetcode.com/problems/knight-dialer/
 */
public class KnightDialer {
    int[][] jumps = new int[][] {
            {4,6},  // 0
            {6,8},  // 1
            {7,9},  // 2
            {4,8},  // 3
            {3,9,0},// 4
            {},     // 5
            {1,7,0},// 6
            {2,6},  // 7
            {1,3},  // 8
            {4,2},  // 9
    };

    // T:O(n), S:O(n)
    public int knightDialer(int n) {
        int[] path = new int[10];    // 0 ~ 9
        Arrays.fill(path, 1);

        for (int i = 2; i <= n; i++) {
            int[] temp = new int[10];
            // [1,1,1,1,1,1,1,1,1,1]
            for (int j = 0; j < 10; j++) {
                for (int jump: jumps[j]) {
                    // [4,6]
                    temp[jump] += path[j];
                    temp[jump] %= 1_000_000_007;
                }
                // [0,1,2,3,4,5,6,7,8,9]
                // [1,1,1,1,1,1,1,1,1,1]
                // [2,2,2,2,3,0,3,2,2,2]
            }

            path = Arrays.copyOf(temp, temp.length);
        }

        int res = 0;
        for (int p: path) {
            res += p;
            res %= 1_000_000_007;
        }
        return res;
    }
}