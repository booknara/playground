package com.booknara.problem.string;

import java.util.ArrayList;
import java.util.Collections;
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
    // Time complexity: O(nlogn), Space complexity: O(n)
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() == 0) {
            return 0;
        }

        List<Integer> minutes = new ArrayList<>();
        for (String s: timePoints) {
            String[] c = s.split(":");
            minutes.add(Integer.parseInt(c[0]) * 60 + Integer.parseInt(c[1]));
        }
        Collections.sort(minutes);

        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            diff = Math.min(diff, Math.abs(minutes.get(i) - minutes.get(i - 1)));
        }

        diff = Math.min(diff, 1440 - minutes.get(timePoints.size() - 1) + minutes.get(0));

        return diff;
    }
}
