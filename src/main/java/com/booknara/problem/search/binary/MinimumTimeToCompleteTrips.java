package com.booknara.problem.search.binary;

/**
 * 2187. Minimum Time to Complete Trips
 * https://leetcode.com/problems/minimum-time-to-complete-trips
 */
public class MinimumTimeToCompleteTrips {
  // T:O(n*logk), S:O(1)
  public long minimumTime(int[] time, int totalTrips) {
    // edge case
    if (time == null || time.length == 0 || totalTrips == 0) return 0;

    int max = 0;
    for (int t : time) {
      max = Math.max(max, t);
    }
    long left = 1;
    long right = (long) max * totalTrips;
    while (left < right) {
      long mid = left + (right - left) / 2;
      if (canFinishTotalTrip(time, mid, totalTrips)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return right;
  }

  public boolean canFinishTotalTrip(int[] time, long maxTime, int totalTrips) {
    long trips = 0;
    for (int t : time) {
      trips += maxTime / t;
    }
    return trips >= totalTrips;
  }
}
/**
 * Input: time = [1,2,3], totalTrips = 5
 * first bus: 1
 * second bus: 2
 * third bus: 3
 * <p>
 * low = 1
 * high = 3 * 5 = 15 seconds
 * 1 -------------- 15
 * mid = low + (high - low) / 2
 * if mid can complete totalTrips
 * high = mid
 * else
 * low = mid + 1
 * return high
 * Output: 3
 */
