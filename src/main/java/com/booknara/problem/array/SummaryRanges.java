package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges (Medium)
 * https://leetcode.com/problems/summary-ranges/
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // System.out.println(nums[i]);
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                print(res, start, end);
                start = nums[i];
                end = nums[i];
            }
        }

        print(res, start, end);

        return res;
    }

    public void print(List<String> list, int s, int e) {
        StringBuilder builder = new StringBuilder();
        if (s == e) {
            builder.append(s);
        } else {
            builder.append(s);
            builder.append("->");
            builder.append(e);
        }

        list.add(builder.toString());
    }
}
