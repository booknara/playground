package com.booknara.problem.hash;

import com.booknara.problem.common.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * 939. Minimum Area Rectangle (Medium)
 * https://leetcode.com/problems/minimum-area-rectangle/
 */
public class MinimumAreaRectangle {
    // T:O(n^2), S:O(n)
    public int minAreaRect(int[][] points) {
        if (points.length == 0) return 0;
        Set<Pair> set = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            set.add(new Pair(points[i][0], points[i][1]));
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                // check if p1 and p2 are in diagonal position
                if (p1[0] != p2[0] && p1[1] != p2[1]) {
                    // able to make a rectagle
                    //(p1[0], p1[1]), (p2[0], p2[1])

                    // (1, 4)    (4,3)
                    // (1, 1),   (4,1)
                    // check whether (p1[0], p2[1]) and (p2[1], p1[0]) exist
                    // [1,1], [4,3] -> check []
                    if (set.contains(new Pair(p1[0], p2[1]))
                            && set.contains(new Pair(p2[0], p1[1]))) {
                        // System.out.println(p1[0] + "," + p1[1]);
                        // System.out.println(p2[0] + "," + p2[1]);
                        // System.out.println();

                        res = Math.min(res, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                    }

                }
            }
        }

        return res < Integer.MAX_VALUE ? res : 0;
    }
}
