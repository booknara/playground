package com.booknara.problem.math;

/**
 * 1344. Angle Between Hands of a Clock (Medium)
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 */
public class AngleBetweenHandsOfClock {
    // T:O(1), S:O(1)
    public double angleClock(int hour, int minutes) {
        if (hour == 12) hour = 0;
        // 1 minute -> 6.0
        double mAngle = minutes * 6.0;
        // 1 hour -> 30.0 + 0.5 * minutes
        double hAngle = (30 * hour) + (0.5 * minutes);

        double res = Math.abs(mAngle - hAngle);

        return res <= 180.0 ? res : 360.0 - res;
    }
}
