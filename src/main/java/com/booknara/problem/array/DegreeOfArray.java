package com.booknara.problem.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. Degree of an Array (Easy)
 * https://leetcode.com/problems/degree-of-an-array/
 */
public class DegreeOfArray {
    // T:O(n), S:O(n)
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Element> map = new HashMap<>();

        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            // count
            Element element;
            if (map.containsKey(nums[i])) {
                element = map.get(nums[i]);
                element.degree++;
                element.rightIdx = i;
            } else {
                element = new Element(1, i, i);
            }

            map.put(nums[i], element);
            degree = Math.max(degree, element.degree);
        }

        //System.out.println(degree);
        int res = nums.length;
        for (int n: nums) {
            Element element = map.get(n);
            if (element.degree == degree) {
                // result candidates
                int len = element.rightIdx - element.leftIdx + 1;
                res = Math.min(res, len);
            }
        }

        return res;
    }

    static class Element {
        int degree;
        int leftIdx;
        int rightIdx;

        Element(int degree, int leftIdx, int rightIdx) {
            this.degree = degree;
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
        }
    }
}
