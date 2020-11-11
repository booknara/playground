package com.booknara.problem.heap

import java.util.*

/**
 * 347. Top K Frequent Elements (Medium)
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
class Solution {
    // T:O(nlogk), S:O(n)
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // non-empty array of Int
        val map = mutableMapOf<Int, Int>()
        for (n in nums) {
            val count = map.getOrDefault(n, 0)
            map[n] = count + 1
        }

        val res = IntArray(k)

        // min-heap
        val pq = PriorityQueue<Map.Entry<Int, Int>>(compareBy { it.value })

        for (entry in map) {
            pq.offer(entry)
            if (pq.size > k) {
                pq.poll()
            }
        }

        var index = 0
        while (!pq.isEmpty()) {
            res[index++] = pq.poll().key
        }

        return res
    }
}

fun main() {
    val input = intArrayOf(1, 1, 1, 2, 2, 3)
    Solution().topKFrequent(input, 2)
}