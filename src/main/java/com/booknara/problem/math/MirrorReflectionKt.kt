package com.booknara.problem.math

/**
 * 858. Mirror Reflection (Medium)
 * https://leetcode.com/problems/mirror-reflection/
 */
class MirrorReflectionKt {
    // T:O(logn), S:O(1)
    fun mirrorReflection(p: Int, q: Int): Int {
        // extension * p = reflection * q
        var extension = q
        var reflection = p

        while (extension % 2 == 0 && reflection % 2 == 0) {
            extension /= 2
            reflection /= 2
        }

        if (extension % 2 == 0 && reflection % 2 == 1) return 0
        if (extension % 2 == 1 && reflection % 2 == 1) return 1
        if (extension % 2 == 1 && reflection % 2 == 0) return 2

        return -1
    }
}