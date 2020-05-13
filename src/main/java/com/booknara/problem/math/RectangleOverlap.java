package com.booknara.problem.math;

/**
 * 836. Rectangle Overlap (Easy)
 * https://leetcode.com/problems/rectangle-overlap/
 */
public class RectangleOverlap {
    // T:O(1), S:O(1)
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1 == null || rec2 == null || rec1.length == 0 || rec2.length == 0) {
            return false;
        }

        int bottomX = Math.max(Math.min(rec1[0], rec1[2]), Math.min(rec2[0], rec2[2]));
        int bottomY = Math.max(Math.min(rec1[1], rec1[3]), Math.min(rec2[1], rec2[3]));

        int topX = Math.min(Math.max(rec1[0], rec1[2]), Math.max(rec2[0], rec2[2]));
        int topY = Math.min(Math.max(rec1[1], rec1[3]), Math.max(rec2[1], rec2[3]));

        return bottomX < topX && bottomY < topY;
    }
}
