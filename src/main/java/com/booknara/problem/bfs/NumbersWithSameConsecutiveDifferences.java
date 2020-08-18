package com.booknara.problem.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 967. Numbers With Same Consecutive Differences (Medium)
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */
public class NumbersWithSameConsecutiveDifferences {
    // T:O(n*2^n), S:O(2^n)
    public int[] numsSameConsecDiff(int N, int K) {
        // Input check: 1 <= N <= 9, 0 <= K <= 9
        if (N == 1) {
            return new int[] {0,1,2,3,4,5,6,7,8,9};
        }

        Queue<Integer> q = new LinkedList<>();
        // add 1 ~ 9
        for (int i = 1; i < 10; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int s = q.poll();
                int n = s % 10;
                if (K == 0) {
                    q.offer(s * 10 + n);
                } else {
                    if (n + K < 10) {
                        q.offer(s * 10 + (n + K));
                    }
                    if (n - K >= 0) {
                        q.offer(s * 10 + (n - K));
                    }
                }
            }

            N--;
            if (N == 1) {
                break;
            }
        }

        int[] res = new int[q.size()];
        int i = 0;
        while (!q.isEmpty()) {
            res[i++] = q.poll();
        }

        return res;
    }

    // Bruce force: TLE T:O(n*k)
    public int[] numsSameConsecDiff1(int N, int K) {
        long start = (long)Math.pow(10, N - 1);
        long end = (long)Math.pow(10, N);

        // edge case. N = 1 (1 ~ 9) -> (0 ~ 9)
        if (start == 1) {
            start--;
        }

        List<Integer> list = new ArrayList<>();
        for (long n = start; n < end; n++) {
            if (n > Integer.MAX_VALUE) {
                break;
            }

            String s = String.valueOf(n);
            boolean pass = true;
            for (int i = 1; i < s.length(); i++) {
                if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != K) {
                    pass = false;
                    break;
                }
            }

            if (pass) {
                list.add((int) n);
            }
        }

        // convert list to int[]
        int[] res = new int[list.size()];
        int i = 0;
        for (int n: list) {
            res[i++] = n;
        }

        return res;
    }
}
