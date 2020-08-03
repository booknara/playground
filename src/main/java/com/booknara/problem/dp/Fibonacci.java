package com.booknara.problem.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 509. Fibonacci Number (Easy)
 * https://leetcode.com/problems/fibonacci-number/
 */
public class Fibonacci {
    // T:O(n1), S:O(1)
    public int fib(int N) {
        if (N < 2) return N;

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        int pp = 0;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }

    public int fib1(int N) {
        // Recursion
        if (N < 2) {
            return N;
        }

        return fib1(N - 1) + fib1(N - 2);
    }

    public int fib2(int N) {
        if (N < 2) {
            return N;
        }

        Integer[] memo = new Integer[N + 1];
        return fib2Helper(memo, N);
    }

    private int fib2Helper(Integer[] memo, int number) {
        if (memo[number] != null) {
            return memo[number];
        }

        int v;
        if (number < 2) {
            v = number;
        } else {
            v = fib2(number - 1) + fib2(number - 2);
        }
        memo[number] = v;

        return v;
    }

    private Map<Integer, Integer> map2 = new HashMap<>();
    public int fib3(int N) {
        // Bottom-up iterative
        for (int i = 0; i <= N; i++) {
            if (i < 2) {
                map2.put(i, i);
            } else {
                map2.put(i, map2.get(i - 1) + map2.get(i - 2));
            }
        }

        return map2.get(N);
    }

    public int fib4(int N) {
        if (N < 2) {
            return N;
        }

        int prev1 = 0, prev2 = 0;
        // Bottom-up iterative (save space complexity - constant)
        int v = 0;
        for (int i = 0; i <= N; i++) {
            if (i < 2) {
                prev1 = 0;
                prev2 = 1;
            } else {
                v = prev1 + prev2;
                prev1 = prev2;
                prev2 = v;
            }
        }

        return v;
    }

    public BigInteger fib5(int N) {
        if (N < 2) {
            return BigInteger.valueOf(N);
        }

        BigInteger prev1 = BigInteger.ZERO, prev2 = BigInteger.ZERO;
        // Bottom-up iterative (save space complexity - constant)
        BigInteger v = BigInteger.ZERO;
        for (int i = 0; i <= N; i++) {
            if (i < 2) {
                prev1 = BigInteger.ZERO;
                prev2 = BigInteger.ONE;
            } else {
                v = prev1.add(prev2);
                prev1 = prev2;
                prev2 = v;
            }
        }

        return v;
    }

    /**
     * [F(n) F(n-1)] = [F(n-1) F(n-2)] * [1, 1]
     *                                   [1, 0]
     * General formula 1
     * [F(n) F(n-1)] = [F(1) F(0)] * ([1, 1]) ** (n - 1)
     *                                [1, 0]
     * General formula 1
     * [F(n + 1) F(n)] =  ([1, 1]) ** n
     * [F(n) F(n-1)]       [1, 0]
     */
    public int fib6(int N) {
        if (N < 2) {
            return N;
        }

        int[][] matrix = new int[][] {{1, 1}, {1, 0}};
        power(matrix, N - 1);
        return matrix[0][0];
    }

    private void power(int[][] matrix, int n) {
        if (n == 0 || n == 1) {
            return;
        }

        power(matrix, n / 2);
        multiplyMatrix(matrix, matrix);

        if (n % 2 != 0) {
            int[][] unit = new int[][] {{1, 1}, {1, 0}};
            multiplyMatrix(matrix, unit);
        }
    }

    private void multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int a1 = (matrix1[0][0] * matrix2[0][0]) + (matrix1[0][1] * matrix2[1][0]);
        int a2 = (matrix1[0][0] * matrix2[0][1]) + (matrix1[0][1] * matrix2[1][1]);
        int a3 = (matrix1[1][0] * matrix2[0][0]) + (matrix1[1][1] * matrix2[1][0]);
        int a4 = (matrix1[1][0] * matrix2[0][1]) + (matrix1[1][1] * matrix2[1][1]);

        matrix1[0][0] = a1;
        matrix1[0][1] = a2;
        matrix1[1][0] = a3;
        matrix1[1][1] = a4;
    }
}
