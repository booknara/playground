package com.booknara.problem.math;

import java.util.Random;

/**
 * 398. Random Pick Index (Medium)
 * https://leetcode.com/problems/random-pick-index/
 */
public class RandomPickIndex {
    int[] nums;
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    // Reservoir sample (https://leetcode.com/problems/random-pick-index/discuss/88072/Simple-Reservoir-Sampling-solution/138382)
    public int pick(int target) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }

            count++;
            if (new Random().nextInt(count) == 0) {
                res = i;
            }
        }

        return res;
    }

//    Map<Integer, List<Integer>> map;
//    public RandomPickIndex(int[] nums) {
//        map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
//            list.add(i);
//            map.put(nums[i], list);
//        }
//    }
//
//    public int pick(int target) {
//        // assume that the target value must exists in the input array
//        List<Integer> list = map.get(target);
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//
//        int random = new Random().nextInt(list.size()); // [0 ~ size - 1]
//        return list.get(random);
//    }
}
