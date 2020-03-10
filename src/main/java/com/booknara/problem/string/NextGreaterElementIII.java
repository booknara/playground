package com.booknara.problem.string;

/**
 * 556. Next Greater Element III (Medium)
 * https://leetcode.com/problems/next-greater-element-iii/
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        if (n == 0) {
            return 0;
        }

        StringBuilder builder = new StringBuilder(String.valueOf(n));
        int first = -1, second = 0;
        for (int i = builder.length() - 1; i > 0; i--) {
            if (builder.charAt(i - 1) < builder.charAt(i)) {
                first = i - 1;
                second = i;
                break;
            }
        }

        if (first == -1) {
            // All ascending
            return -1;
        }

        int smallest = second;
        for (int i = first + 1; i < builder.length(); i++) {
            if (builder.charAt(first) < builder.charAt(i) &&
                    builder.charAt(i) <= builder.charAt(smallest)) {
                smallest = i;
            }
        }

        // Swap first and smallest
        swap(builder, first, smallest);

        int last = builder.length() - 1;
        while (second < last) {
            swap(builder, second, last);
            second++;
            last--;
        }

        // Integer max value handling
        long val = Long.parseLong(builder.toString());
        return val > Integer.MAX_VALUE ? -1 : (int) val;
    }

    public void swap(StringBuilder builder, int i, int j) {
        char temp = builder.charAt(i);
        builder.setCharAt(i, builder.charAt(j));
        builder.setCharAt(j, temp);
    }
}
