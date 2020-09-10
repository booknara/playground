package com.booknara.problem.string;

/**
 * 38. Count and Say (Easy)
 * https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
    // T:O(2^n), S:O(2^n)
    public String countAndSay(int n) {
        // input check
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                builder.append("1");
                continue;
            }
            // from 2
            StringBuilder temp = new StringBuilder();
            int num = -1;
            int count = 0;
            for (int j = 0; j < builder.length(); j++) {
                char c = builder.charAt(j);
                if (num == -1) {    // the first number
                    num = c - '0';
                    count++;
                } else if (num == c - '0') {
                    count++;
                } else {
                    temp.append(count);
                    temp.append(num);
                    count = 1;
                    num = c - '0';
                }
            }

            if (count != 0) {
                temp.append(count);
                temp.append(num);
            }

            builder = temp;
        }

        return builder.toString();
    }

    // T:O(2^n), S:O(2^n)
    public String countAndSay1(int n) {
        if (n == 1) return "1";
        String prev = countAndSay1(n - 1);

        StringBuilder builder = new StringBuilder();
        int num = -1;
        int count = 0;
        for (int j = 0; j < prev.length(); j++) {
            char c = prev.charAt(j);
            if (num == -1) {    // the first number
                num = c - '0';
                count++;
            } else if (num == c - '0') {
                count++;
            } else {
                builder.append(count);
                builder.append(num);
                count = 1;
                num = c - '0';
            }
        }

        if (count != 0) {
            builder.append(count);
            builder.append(num);
        }

        return builder.toString();
    }

}
