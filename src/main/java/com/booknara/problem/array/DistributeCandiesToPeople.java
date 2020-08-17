package com.booknara.problem.array;

/**
 * 1103. Distribute Candies to People (Easy)
 * https://leetcode.com/problems/distribute-candies-to-people/
 */
public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        // input check, candies and num_people >= 1
        int[] nums = new int[num_people];
        int count = 1;
        int i = 0;
        while (candies > 0) {
            if (candies < count) {
                nums[i % num_people] += candies;
                candies = 0;
            } else {
                nums[i % num_people] += count;
                candies -= count;
            }

            count++;
            i++;
        }

        return nums;
    }
}
