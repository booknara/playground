package com.booknara.problem.heap;

import java.util.PriorityQueue;

/**
 * 179. Largest Number (Medium)
 * https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {
    // T:O(nlogn), S:O(n)
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            String first = s1 + s2;     // 3, 30 -> 330
            String second = s2 + s1;    // 3, 30 -> 303
            return second.compareTo(first); // in this case, make reverse order
        });

        for (int n: nums) {
            pq.offer(String.valueOf(n));
        }

        StringBuilder builder = new StringBuilder();
        while (!pq.isEmpty()) {
            String s = pq.poll();
            builder.append(s);
        }

        // edge case [0, 0], only need to check the first character
        return builder.charAt(0) == '0' ? "0" : builder.toString();
    }
}
