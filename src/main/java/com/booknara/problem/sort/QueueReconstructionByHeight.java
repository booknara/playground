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
        if (people == null || people.length == 0) {
            return people;
        }

        Arrays.sort(people, (p1, p2) -> {
            // 1. height descending, 2. k ascending
            if (p1[0] == p2[0]) {
                // k ascending (e.g. [7, 0] , [7, 1], [7, 2])
                return Integer.compare(p1[1], p2[1]);
            }
            // height descending
            return Integer.compare(p2[0], p1[0]);
        });

        List<int[]> res = new ArrayList<>();
        // [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
        // And then k means index
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }

        return res.toArray(new int[res.size()][2]);
    }
}
