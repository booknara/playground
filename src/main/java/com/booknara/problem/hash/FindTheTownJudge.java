package com.booknara.problem.hash;

/**
 * 997. Find the Town Judge (Easy)
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class FindTheTownJudge {
    // T:O(n, the length of trust array), S:O(n, the number of N)
    public int findJudge(int N, int[][] trust) {
        if (N == 1 && trust.length == 0) {
            return 1;
        }

        if (trust.length == 0) {
            return -1;
        }

        int[] truster = new int[N];
        int[] trustee = new int[N];
        for (int[] t: trust) {
            // t[0] trusts t[1]
            truster[t[0] - 1]++;
            trustee[t[1] - 1]++;
        }

        for (int i = 0; i < trustee.length; i++) {
            if (trustee[i] == N - 1) {
                return truster[i] == 0 ? i + 1 : -1;
            }
        }

        return -1;
    }
}
