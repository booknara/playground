package com.booknara.problem.math

/**
 * 829. Consecutive Numbers Sum (Hard)
 * https://leetcode.com/problems/consecutive-numbers-sum/
 */
class Solution {
    // T:O(n), S:(1)
    fun consecutiveNumbersSum(N: Int): Int {
        var res = 1 // start with 1 because of N itself

        for (i in 2..N) {
            val sum = i * (i + 1) / 2
            if (N - sum < 0) break

            if (((N - sum) % i) == 0) res++
        }

        return res
    }
}
/*
the number of consecutive number (n)
1 + 2 + 3 + .. + n => n (n + 1) / 2
2 + 3 + 4 + ...+ n + 1 -> 1 + 2 + 3 + .. + n + n => n (n + 1) / 2 + n
3 + 4 + 5 + ...+ n + 1 + n + 2 -> 1 + 2 + 3 + .. + n + n + n => n (n + 1) / 2 + 2n
k + ... + n + k - 1 -> 1 + 2 + 3 + .. + n + n + n => n (n + 1) / 2 + (k - 1) * n

N - n (n + 1) / 2 = (k - 1) * n
N - n (n + 1) / 2 mod n == 0 -> answer
 */