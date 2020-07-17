package com.booknara.problem.bit;

/**
 * 1486. XOR Operation in an Array (Easy)
 * https://leetcode.com/problems/xor-operation-in-an-array/
 */
public class XOROperationInAnArray {
    // T:O(n), S:O(1)
    public int xorOperation(int n, int start) {
        // input check
        if (n == 0) return 0;

        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= start + 2 * i;
        }

        return res;
    }
}
