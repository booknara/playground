package com.booknara.problem.array;

import java.util.List;

/**
 * Leet code : 539. Minimum Time Difference (Medium)
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * 1. The number of time points in the given list is at least 2 and won't exceed 20000.
 * 2. The input time is legal and ranges from 00:00 to 23:59.
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() == 0) {
            return 0;
        }

        // 24 * 60 = 1440
        boolean[] time = new boolean[1440];
        for (String t: timePoints) {
            String[] s = t.split(":");
            int seconds = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            if (time[seconds]) {
                return 0;
            } else {
                time[seconds] = true;
            }
        }

        int minDiff = 1440;
        int prev = -1;
        int first = 0;
        int last = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[i]) {
                if (prev == -1) {
                    prev = i;
                    first = i;
                } else {
                    minDiff = getMax(minDiff, i - prev, 1440 - i + prev);
                    prev = i;
                }

                last = i;
            }
        }

        minDiff = Math.min(minDiff, 1440 - last + first);
        return minDiff;
    }

    public int getMax(int i1, int i2, int i3) {
        return i1 < i2 ? (i1 < i3 ? i1 : i3) : (i2 < i3 ? i2 : i3);
    }
}
