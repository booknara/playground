package com.booknara.problem.twopointers;

import java.util.Arrays;

/**
 * 881. Boats to Save People (Medium)
 * https://leetcode.com/problems/boats-to-save-people/
 */
public class BoatsToSavePeople {
    // O(n)
    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }

        int[] bucket = new int[limit + 1];
        for (int p: people) {
            bucket[p]++;
        }

        int count = 0;
        int l = 1, r = bucket.length - 1;
        while (l <= r) {
            // equal or less than 0
            while (l <= r && bucket[l] <= 0) {
                l++;
            }
            // equal or less than 0
            while (l <= r && bucket[r] <= 0) {
                r--;
            }

            // Termination condition
            if (l > r) {
                break;
            }

            if (l + r <= limit) {
                bucket[l]--;
            }
            bucket[r]--;
            count++;
        }

        return count;
    }

    // O(nlogn)
    public int numRescueBoats1(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }

        Arrays.sort(people);
        int count = 0;
        int l = 0, r = people.length - 1;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }
            r--;
            count++;
        }

        return count;
    }
}
