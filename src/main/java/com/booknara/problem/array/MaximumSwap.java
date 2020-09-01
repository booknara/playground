package com.booknara.problem.array;

/**
 * 670. Maximum Swap (Medium)
 * https://leetcode.com/problems/maximum-swap/
 */
public class MaximumSwap {
    // T:O(n), S:(1)
    public int maximumSwap(int num) {
        // input check
        if (num < 10) return num;

        char[] s = String.valueOf(num).toCharArray();
        int[] bucket = new int[10];
        for (int i = 0; i < s.length; i++) {
            int n = Character.getNumericValue(s[i]);
            bucket[n] = i;
        }

        for (int i = 0; i < s.length; i++) {
            int n = Character.getNumericValue(s[i]);
            for (int j = 9; j > n; j--) { // [9 ~ 3]
                if (bucket[j] > i) {
                    swap(s, i, bucket[j]);
                    return Integer.parseInt(new String(s));
                }
            }
        }

        return num;
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
/**
 Input: 2736
 Output: 7236

 Input: 2739
 Input: 9732

 Input:  9824
 Output: 9842
 0,1,2,3,4,5,6,7,8,9
 bucket = [0,0,2,0,3,0,0,0,1,0]
 char[] s = String.valueOf(num).toCharArray();
 for (int i = 0; i < s.length; i++) {
 int n = Character.getNumericValue(s[i]));
 for (int j = 9; j > n; j--) { // [9 ~ 3]
 if (bucket[j] > i) {
 swap(s, i, bucket[j]);
 return Integer.parseInt(s);
 }
 }
 }

 return num;
 */