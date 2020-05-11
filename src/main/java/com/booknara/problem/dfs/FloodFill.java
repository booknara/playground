package com.booknara.problem.dfs;

/**
 * 733. Flood Fill (Easy)
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {
    // T:O(n^2), S:O(1)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int srcColor, int newColor) {
        if (sr < 0 || sr == image.length || sc < 0 || sc == image[sr].length || image[sr][sc] != srcColor) {
            return;
        }

        image[sr][sc] = newColor;

        // 4 direction
        // top
        dfs(image, sr - 1, sc, srcColor, newColor);
        // bottom
        dfs(image, sr + 1, sc, srcColor, newColor);
        // left
        dfs(image, sr, sc - 1, srcColor, newColor);
        // right
        dfs(image, sr, sc + 1, srcColor, newColor);
    }
}
