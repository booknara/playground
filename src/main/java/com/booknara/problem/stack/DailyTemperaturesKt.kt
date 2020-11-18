package com.booknara.problem.stack

import java.util.*

/**
 * 739. Daily Temperatures (Medium)
 * https://leetcode.com/problems/daily-temperatures/
 */
class DailyTemperaturesKt {
    // T:O(n), S:O(n)
    fun dailyTemperatures(T: IntArray): IntArray {
        val res = IntArray(T.size)
        if (T.size < 2) return res

        val stack = Stack<Int>()
        for (i in T.size - 1 downTo 0) {
            // println(T[i])
            // pop all the smaller or equivalent values after i index
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop()
            }

            if (stack.isEmpty()) {
                res[i] = 0
            } else {
                res[i] = stack.peek() - i
            }

            stack.push(i)
        }

        return res
    }
}