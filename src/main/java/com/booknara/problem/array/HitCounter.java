package com.booknara.problem.array;

/**
 * 362. Design Hit Counter (Medium)
 * https://leetcode.com/problems/design-hit-counter/
 */
public class HitCounter {
    private int[] times;
    private int[] counter;

    public HitCounter() {
        times = new int[300];
        counter = new int[300];
    }

    public void hit(int timestamp) {
        int mod = timestamp % 300;
        if (times[mod] == timestamp) { // Multiple input
            counter[mod]++;
        } else {
            counter[mod] = 1;
            times[mod] = timestamp;
        }
    }

    public int getHits(int timestamp) {
        int res = 0;
        for (int i = 0; i < times.length; i++) {
            if (timestamp - times[i] < 300) {
                res += counter[i];
            }
        }

        return res;
    }
}
