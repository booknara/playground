package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges (Medium)
 * https://leetcode.com/problems/summary-ranges/
 */
public class SummaryRanges {
    // T:O(n), S:O(1)
    public List<String> summaryRanges(int[] nums) {
        // input check
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        /*Input: nums = [0,1,2,4,5,7]
        Output: ["0->2","4->5","7"]
        */
        Integer start = null, end = null;
        for (int i = 0; i < nums.length; i++) {
            if (start == null) {
                start = nums[i];
                end = nums[i];
            } else if (end + 1 == nums[i]) {
                end = nums[i];
            } else {
                // output
                res.add(getOutput(start, end));
                start = nums[i];
                end = nums[i];
            }
        }
        // the last range
        res.add(getOutput(start, end));

        return res;
    }

    public String getOutput(int start, int end) {
        if (start == end) return String.valueOf(start);
        return start + "->" + end;
    }
}
