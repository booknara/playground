package com.booknara.problem.greedy;

/**
 * 1007. Minimum Domino Rotations For Equal Row (Medium)
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        if (n != m || n * m == 0) {
            return -1;
        }

        // Ensure that the length of A, B is same
        int target1 = A[0];
        int target2 = B[0];
        if (target1 == target2) {
            return minRotate(A, B, target1);
        }

        int res1 = minRotate(A, B, target1);
        int res2 = minRotate(A, B, target2);

        if (res1 == -1 && res2 == -1) {
            return -1;
        }

        if (res1 != -1 && res2 != -1) {
            return Math.min(res1, res2);
        }

        return Math.max(res1, res2);
    }

    public int minRotate(int[] A, int[] B, int target) {
        int rotateA = 0;
        int rotateB = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] != target && B[i] != target) {
                return -1;
            } else if (A[i] != target) {
                rotateA++;
            } else if (B[i] != target) {
                rotateB++;
            }
        }

        return Math.min(rotateA, rotateB);
    }
}
