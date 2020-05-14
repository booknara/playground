package com.booknara.problem.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. Queue Reconstruction by Height (Medium)
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class QueueReconstructionByHeight {
    // T:O(n*logn), S:O(1)
    public int[][] reconstructQueue(int[][] people) {
        // Rule #1 Order by the height because the tallest person should be front
        // Rule #2 The height is same, order by k ascending (7, 0) , (7, 1), (7, 2)
        Arrays.sort(people, (p1, p2) -> {
            if (Integer.compare(p1[0], p2[0]) != 0) {
                return Integer.compare(p2[0], p1[0]);
            }

            return Integer.compare(p1[1], p2[1]);
        });
        // [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
        // And then k means index
        List<int[]> list = new ArrayList<>();
        for (int[] p: people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[0][]);
    }
}
