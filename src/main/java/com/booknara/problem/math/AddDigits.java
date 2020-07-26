package com.booknara.problem.math;

/**
 * 258. Add Digits (Easy)
 * https://leetcode.com/problems/add-digits/
 */
public class AddDigits {
    // T:O(1), S:O(1)
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }

    public int addDigits1(int num) {
        while (num > 9) {
            num = add(num);
        }

        return num;
    }

    public int add(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }

        return res;
    }
}
