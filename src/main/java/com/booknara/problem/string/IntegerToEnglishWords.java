package com.booknara.problem.string;

/**
 * 273. Integer to English Words (Hard)
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglishWords {
    // T:O(1), S:O(1)
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder builder = new StringBuilder();
        int count = 0;
        while (num > 0) {
            int mod = num % 1000;
            num /= 1000;

            if (mod > 0) {
                builder.insert(0, getValue(mod) + " " + getUnit(count) + " ");
            }

            count++;
        }

        return builder.toString().trim();
    }

    public String getValue(int num) {
        StringBuilder builder = new StringBuilder();
        // 917
        int hundred = num / 100;
        if (hundred > 0) {
            builder.append(getNumber(hundred)).append(" ").append("Hundred").append(" ");
        }
        num %= 100;
        if (num >= 11 && num <= 19) {
            builder.append(getTeen(num));
            return builder.toString();
        }

        int ten = num / 10;
        if (ten > 0) {
            builder.append(getTen(ten)).append(" ");
        }

        int one = num % 10;
        if (one > 0) {
            builder.append(getNumber(one));
        }

        return builder.toString().trim();
    }

    public String getNumber(int num) {
        if (num == 1) return "One";
        if (num == 2) return "Two";
        if (num == 3) return "Three";
        if (num == 4) return "Four";
        if (num == 5) return "Five";
        if (num == 6) return "Six";
        if (num == 7) return "Seven";
        if (num == 8) return "Eight";
        if (num == 9) return "Nine";
        return "";
    }

    public String getTen(int num) {
        if (num == 1) return "Ten";
        if (num == 2) return "Twenty";
        if (num == 3) return "Thirty";
        if (num == 4) return "Forty";
        if (num == 5) return "Fifty";
        if (num == 6) return "Sixty";
        if (num == 7) return "Seventy";
        if (num == 8) return "Eighty";
        if (num == 9) return "Ninety";
        return "";
    }

    public String getTeen(int num) {
        if (num == 11) return "Eleven";
        if (num == 12) return "Twelve";
        if (num == 13) return "Thirteen";
        if (num == 14) return "Fourteen";
        if (num == 15) return "Fifteen";
        if (num == 16) return "Sixteen";
        if (num == 17) return "Seventeen";
        if (num == 18) return "Eighteen";
        if (num == 19) return "Nineteen";
        return "";
    }

    public String getUnit(int num) {
        if (num == 1) return "Thousand";
        if (num == 2) return "Million";
        if (num == 3) return "Billion";

        return "";
    }
}
