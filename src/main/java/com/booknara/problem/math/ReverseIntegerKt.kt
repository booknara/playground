package com.booknara.problem.math

/**
 * 7. Reverse Integer (Easy)
 * https://leetcode.com/problems/reverse-integer/
 */
class ReverseIntegerKt {
    // T:O(logn), S:O(1)
    fun reverse(x: Int): Int {
        if (x == 0) return 0

        val sign = if (x < 0) -1 else 1

        var num: Long = Math.abs(x.toLong())

        var res = 0L
        while (num != 0L) {
            val mod = num % 10
            num /= 10L
            res = res * 10L + mod
            if (res < Int.MIN_VALUE.toLong()
                    || res > Int.MAX_VALUE.toLong()) return 0
        }

        return res.toInt() * sign
    }
}