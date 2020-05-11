package com.booknara.problem.dfs;

import com.booknara.problem.common.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * 733. Flood Fill (Easy)
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {
    // T:O(n^2), S:O(n^2, because of memoization)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }

        // No need to process if the existing and new color are same
        if (image[sr][sc] != newColor) {
            Set<Pair<Integer, Integer>> set = new HashSet<>();
            dfs(image, sr, sc, newColor, set);
        }

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, Set<Pair<Integer, Integer>> set) {
        if (set.contains(new Pair(sr, sc))) return;
        int prevColor = image[sr][sc];
        image[sr][sc] = newColor;

        set.add(new Pair(sr, sc));
        // 4 direction
        // top
        if (sr - 1 >= 0 && prevColor == image[sr - 1][sc]) dfs(image, sr - 1, sc, newColor, set);
        // bottom
        if (sr + 1 < image.length && prevColor == image[sr + 1][sc]) dfs(image, sr + 1, sc, newColor, set);
        // left
        if (sc - 1 >= 0 && prevColor == image[sr][sc - 1]) dfs(image, sr, sc - 1, newColor, set);
        // right
        if (sc + 1 < image[sr].length && prevColor == image[sr][sc + 1]) dfs(image, sr, sc + 1, newColor, set);
    }
}
