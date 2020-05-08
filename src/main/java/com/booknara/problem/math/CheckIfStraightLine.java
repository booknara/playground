package com.booknara.problem.math;

/**
 * 1232. Check If It Is a Straight Line (Easy)
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */
public class CheckIfStraightLine {
    // T:O(n), S:O(1)
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length <= 1) {
            return true;
        }

        // get the slope using two pointers
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];
        double proportion = dx * dy == 0 ? 0 : dx / dy;
        // System.out.println(proportion);
        for (int i = 2; i < coordinates.length; i++) {
            int localDx = coordinates[i][0] - coordinates[1][0];
            int localDy = coordinates[i][1] - coordinates[1][1];

            double localProportion = localDx * localDy == 0 ? 0 : localDx / localDy;
            //System.out.println("-- "+ localProportion);
            if (proportion - localProportion != 0) {
                return false;
            }
        }

        return true;
    }
}
