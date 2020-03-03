package com.booknara.problem.greedy;

/**
 * 860. Lemonade Change (Easy)
 * https://leetcode.com/problems/lemonade-change/
 */
public class LemonadeChange {
    public boolean lemonadeChangeSimple(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }

        int five = 0, ten = 0, twenty = 0;
        for (int i: bills) {
            if (i == 20) {
                if (ten == 0) {
                    if (five < 3) return false;

                    five = five - 3;
                } else {
                    ten--;
                    if (five == 0) return false;

                    five--;
                }
                twenty++;
            } else if (i == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                five++;
            }
        }

        return true;
    }

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }

        int[] changes = new int[3];
        for (int i = 0; i < bills.length; i++) {
            // Bills are either $5, $10, $20

            int change = bills[i] - 5;
            if (change == 15) {
                // $20
                if (changes[1] > 0) {
                    // $10 + $5
                    changes[1]--;
                    if (changes[0] > 0) {
                        changes[0]--;
                    } else {
                        return false;
                    }
                } else {
                    // $5 * 3
                    if (changes[0] > 2) {
                        changes[0] = changes[0] - 3;
                    } else {
                        return false;
                    }
                }

                changes[2]++;
            } else if (change == 5) {
                // $10
                if (changes[0] > 0) {
                    changes[0]--;
                } else {
                    return false;
                }

                changes[1]++;
            } else {
                // $5
                changes[0]++;
            }
        }

        return true;
    }
}
