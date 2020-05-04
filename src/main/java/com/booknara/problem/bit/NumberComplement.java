package com.booknara.problem.bit;

/**
 * 476. Number Complement (Easy)
 * https://leetcode.com/problems/number-complement/
 */
public class NumberComplement {
    // T: O(1), S:O(1)
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }

        // e.g. 5(101) ^ (1000)
        int mask = (Integer.highestOneBit(num) << 1) - 1;  // all 1's mask
        return num ^ mask;
    }

    // T: O(1), S:O(1)
    public int findComplement1(int num) {
        if (num == 0) {
            return 1;
        }

        int i = 0, res = 0;
        while (num != 0) {
            int n = (num & 1) == 1 ? 0 : 1;
            // System.out.println(n);
            if (n == 1) res += Math.pow(2, i);
            i++;
            num = num >> 1;
        }

        return res;
    }
}
