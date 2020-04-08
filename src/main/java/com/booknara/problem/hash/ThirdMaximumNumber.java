package com.booknara.problem.hash;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 414. Third Maximum Number (Easy)
 * https://leetcode.com/problems/third-maximum-number/
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        long highMax = Long.MIN_VALUE;
        long middleMax = Long.MIN_VALUE;
        long lowMax = Long.MIN_VALUE;

        for (int n: nums) {
            if (n > highMax) {
                lowMax = middleMax;
                middleMax = highMax;
                highMax = n;
            } else if (n < highMax && n > middleMax) {
                lowMax = middleMax;
                middleMax = n;
            } else if (n < middleMax && n > lowMax) {
                lowMax = n;
            }
        }

        if (lowMax == Long.MIN_VALUE) {
            return (int) highMax;
        } else {
            return (int) lowMax;
        }
    }

    // Set
    public int thirdMax1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
            if (set.size() > 3) {
                int min = Collections.min(set);
                set.remove(min);
            }
        }

        if (set.size() <= 2) {
            return Collections.max(set);
        }

        return Collections.min(set);
    }
}
