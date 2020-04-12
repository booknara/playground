package com.booknara.problem.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 1197. Minimum Knight Moves (Medium)
 * https://leetcode.com/problems/minimum-knight-moves/
 */
public class MinimumKnightMoves {
    Map<String, Integer> visited = new HashMap<>();
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        if (x + y == 0) {
            return 0;
        }

        // Base case: (1, 1) or (2, 0)
        if (x + y == 2) {
            return 2;
        }

        String move1 = Math.abs(x - 1) + "," + Math.abs(y - 2);
        String move2 = Math.abs(x - 2) + "," + Math.abs(y - 1);

        int path1 = 0;
        int path2 = 0;

        if (visited.containsKey(move1)) {
            path1 = visited.get(move1);
        } else {
            path1 = minKnightMoves(Math.abs(x - 1), Math.abs(y - 2));
            visited.put(move1, path1);
        }

        if (visited.containsKey(move2)) {
            path2 = visited.get(move2);
        } else {
            path2 = minKnightMoves(Math.abs(x - 2), Math.abs(y - 1));
            visited.put(move2, path2);
        }

        return Math.min(path1, path2) + 1;
    }
}
