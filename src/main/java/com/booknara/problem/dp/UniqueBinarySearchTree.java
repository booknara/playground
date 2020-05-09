package com.booknara.problem.dp;

/**
 * 96. Unique Binary Search Trees (Medium)
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 *    F(i, n) = G(i - 1) * G(n - i)
 *
 *    G(n) = F(1, n) + F(2, n) + ... + F(n, n)
 *    G(n) = Sum i=1 to n, F(i, n) => Sum i=1 to n, G(i - 1) * G(n - i)
 */

public class UniqueBinarySearchTree {
    // T: O(N^2), S: O(N)
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }

        int[] graph = new int[n + 1]; // Memoization
        graph[0] = 1;
        graph[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // To get graph[i] value, sum 1 to i using j, G(j - 1) * G(i - j)
                graph[i] += (graph[j - 1] * graph[i - j]);
            }
        }

        return graph[n];
    }
}
