package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. Brick Wall (Medium)
 * https://leetcode.com/problems/brick-wall/
 */
public class BrickWall {
    // T:O(n, the total number of bricks), S:O(m, the number of width)
    public int leastBricks(List<List<Integer>> wall) {
        // input check
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (List<Integer> list: wall) {
            int sum = 0;
            // exclude the end line
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                int c = map.getOrDefault(sum, 0);
                map.put(sum, c + 1);
                max = Math.max(max, c + 1);
            }
        }

        return wall.size() - max;
    }
}
