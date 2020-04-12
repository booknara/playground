package com.booknara.problem.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight (Easy)
 * https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w: stones) {
            pq.offer(w);
        }

        while (pq.size() >= 2) {
            int x = pq.poll();
            int y = pq.poll();
            if (x == y) {
                continue;
            }

            pq.offer(Math.abs(x - y));
        }

        return pq.size() == 0 ? 0 : pq.poll();
    }
}
