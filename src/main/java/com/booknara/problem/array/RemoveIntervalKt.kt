package com.booknara.problem.array

/**
 * 1272. Remove Interval (Medium)
 * https://leetcode.com/problems/remove-interval/
 */
class RemoveIntervalKt {
    // T:O(n), S:O(n)
    fun removeInterval(intervals: Array<IntArray>, toBeRemoved: IntArray): List<List<Int>> {
        // input check, intervals.length >= 1
        val res: MutableList<List<Int>> = ArrayList()

        for (i in intervals.indices) {
            val start = intervals[i][0]
            val end = intervals[i][1]
            val startMax = Math.max(start, toBeRemoved[0])
            val endMin = Math.min(end, toBeRemoved[1])
            if (startMax < endMin) {
                // overlapped
                if (start < toBeRemoved[0]) {
                    res.add(listOf(start, toBeRemoved[0]))
                }
                if (end > toBeRemoved[1]) {
                    res.add(listOf(toBeRemoved[1], end))
                }
            } else {
                // non-overlapped
                res.add(listOf(intervals[i][0], intervals[i][1]))
            }
        }

        return res
    }
}
/**
Sorted intervals
Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
Output: [[0,1],[6,7]]

[0     2]
[3   4]
[5   7]
[1                6]

[0,1], [6,7]
loop intervals
start, end
1. non-overlapped -> add the interval to result set
2. overlapped ->
- the start point check
start point < toBeRemoved.start -> [start,toBeRemoved.start]
- the end point check
end point > toBeRemoved.end -> [toBeRemoved.end,end]

- fully overlapped -> skip

 */