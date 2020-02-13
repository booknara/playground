package com.booknara.problem.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < sum.length; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public int subarraySumWithoutSpace(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public int subarraySumWithHash(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            int z = map.getOrDefault(sum, 0) + 1;
            map.put(sum, z);
        }

        return count;
    }
}
