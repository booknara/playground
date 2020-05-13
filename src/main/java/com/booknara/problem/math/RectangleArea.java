package com.booknara.problem.math;

/**
 * 223. Rectangle Area (Medium)
 * https://leetcode.com/problems/rectangle-area/
 */
public class RectangleArea {
    // T:O(1), S:O(1)
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // First one: (A, B) ~ (C, D)
        // Second one: (E, F) ~ (G, H)
        // First rectangle Area
        int firstArea = Math.abs(C - A) * Math.abs(D - B);
        // Second rectangle Area
        int secondArea = Math.abs(G - E) * Math.abs(H - F);

        // Find Overlapped
        int bottomX = Math.max(Math.min(A, C), Math.min(E, G));
        int bottomY = Math.max(Math.min(B, D), Math.min(F, H));

        int topX = Math.min(Math.max(A, C), Math.max(E, G));
        int topY = Math.min(Math.max(B, D), Math.max(F, H));

        int overlappedArea = 0;
        if (bottomX < topX && bottomY < topY) {
            overlappedArea = Math.abs(topX - bottomX) * Math.abs(topY - bottomY);
        }

        return firstArea + secondArea - overlappedArea;
    }
}