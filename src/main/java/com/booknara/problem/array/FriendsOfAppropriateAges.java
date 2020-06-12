package com.booknara.problem.array;

/**
 * 825. Friends Of Appropriate Ages (Medium)
 * https://leetcode.com/problems/friends-of-appropriate-ages/
 */
public class FriendsOfAppropriateAges {
    // T:O(1), S:O(1)
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) {
            return 0;
        }

        int[] count = new int[121];
        for (int age: ages) {
            count[age]++;
        }

        int total = 0;
        for (int i = 1; i < 121; i++) {
            for (int j = 1; j < 121; j++) {
                if (count[i] == 0 || count[j] == 0) continue;
                if (isAppropriateAges(i, j)) {
                    total += count[i] * count[j];
                    if (i == j) total -= count[i];
                }
            }
        }

        return total;
    }

    public boolean isAppropriateAges(int a, int b) {
        if ((b <= (0.5 * a) + 7) || (b > a)) {
            return false;
        }

        return true;
    }
}
