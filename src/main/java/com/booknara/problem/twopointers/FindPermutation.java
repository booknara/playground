package com.booknara.problem.twopointers;

/**
 * 484. Find Permutation (Medium)
 * https://leetcode.com/problems/find-permutation/
 */
public class FindPermutation {
    // T:O(n), S:O(1)
    public int[] findPermutation(String s) {
        // input check
        if (s == null || s.length() == 0) return new int[] {};

        // assume s only contains "D" or "I"

        int n = s.length() + 1;
        int[] nums = new int[n];
        // nums[] -> 1,2,3,...n
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                r++;
            } else {
                if (l != r) {
                    reverse(nums, l, r);
                }
                l = r + 1;
                r++;
            }
        }

        // the end pointer handling
        if (l != r) {
            reverse(nums, l, r);
        }

        return nums;
    }

    // T:O(n!), S:(n), TLE
    public int[] findPermutation1(String s) {
        // 1. input clarification (empty string)
        if (s == null || s.length() == 0) return new int[] {};

        // 2. input clarification (D or I)
        for (char c: s.toCharArray()) {
            if (c != 'D' && c != 'I') {
                throw new IllegalArgumentException("not having D or I");
            }
        }

        int count = 1;
        int[] nums = new int[s.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            nums[i] = i + 1;
            count *= i + 1;
        }
        // System.out.println(count);
        int i = 0;
        while (i < count) {
            if (validate(nums, s)) return nums;
            nextPermutation(nums);
            i++;
        }

        return new int[] {};
    }

    public void nextPermutation(int[] nums) {
        // input check
        if (nums == null || nums.length <= 1) return;

        // edge case (e.g 4321 -> descending order) : anscending(1234)

        int inverseIdx = -1;
        // 1. loop from the end to the start
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                continue;
            }

            // find inverseIdx
            inverseIdx = i;
            int nextIdx = 0;
            //System.out.println(inverseIdx);
            for (int j = nums.length - 1; j > inverseIdx; j--) {
                if (nums[inverseIdx] < nums[j]) {
                    nextIdx = j;
                    break;
                }
            }

            // swap between inverseIdx and nextIdx
            int temp = nums[inverseIdx];
            nums[inverseIdx] = nums[nextIdx];
            nums[nextIdx] = temp;
            break;
        }

        // if (inverseIdx == -1) {
        //     // array is descending order
        //     reverse(nums, 0, nums.length - 1);
        // } else {
        //     reverse(nums, inverseIdx + 1, nums.length - 1);
        // }
        reverse(nums, inverseIdx + 1, nums.length - 1);
    }

    public boolean validate(int[] nums, String rule) {
        StringBuilder res = new StringBuilder();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {  // "I"
                res.append("I");
            } else {
                res.append("D");
            }
        }

        return rule.equals(res.toString());
    }

    public void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}


// input : String s -> only contains "D" or "I"
// ouput : integer array (length : s.length() + 1)

// e.g input: "DI"
// 1 ~ 3(2 + 1), (1,2,3)
// 123, 132, 213, 231, 312, 321 -> 3 * 2 * 1 = 6
// 213, 312 -> 213 which the lexicographically smallest permutation of [1, 2, ... n]

// bruce force solution (recursive)
// 1. generate all the permutations (for #3, the permutation is needed to generate lexicographically)
// 123, 132, 213, 231, 312, 321 -> 3 * 2 * 1 = 6
// 2. validate each permutation with secret signature
// 3. find the first valid permutation and return the answer
// T:O(n!), T(n) = n * T(n-1) + O(1)

// next permutation solution (iterative)
// 1. start generating all the permutations (for #3, the permutation is needed to generate lexicographically)
// 123, 132, 213, 231, 312, 321 -> 3 * 2 * 1 = 6
// 2. whenever the permutation is generated, validate the permutation with secret signature
// 3. if valid, return the permutation
// T:O(n!), S:(n!), early termination
