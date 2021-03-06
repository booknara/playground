package com.booknara.problem.dp;

import java.util.*;

/**
 * 279. Perfect Squares (Medium)
 * https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquares {
    // DP, T:O(n*sqrt(n)), S:(n)
    // input : positive integer
    // output : the least number of perfect square numbers
    public int numSquares(int n) {
        // input check
        if (n < 4) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            int min = i;    // Integer.MAX_VALUE because i can be many 1
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = min;
        }

        return dp[n];
    }

    // BFS, T:O(h/2), S:(sqrt(n)^h)
    public int numSquares1(int n) {
        if (n <= 3) return n;
        // find perfect square numbers until n
        List<Integer> ps = getPerfectNumbers(n);
        Set<Integer> visited = new HashSet<>();
        // BFS traverse
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        queue.offer(null);
        int level = 0;
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            if (num == null) {
                level++;
                if (queue.peek() == null) break;
                else queue.offer(null);
            } else {
                if (num == 0) return level;

                for (int i = 0; i < ps.size(); i++) {
                    if (ps.get(i) <= num) {
                        int remaining = num - ps.get(i);
                        if (!visited.contains(remaining)) {
                            queue.offer(remaining);
                            visited.add(remaining);
                        }
                    }
                }
            }
        }

        return -1;
    }

    private List<Integer> getPerfectNumbers(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n / 2; i++) {
            if (i * i <= n) {
                list.add(i * i);
            }
        }

        return list;
    }
}
