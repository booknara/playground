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
        int unit = 0;
        // 1234567891
        while (num > 0) {
            // 1_000_000
            if (num % 1000 != 0) {
                String s = " " + getNumber(num % 1000) + " " + getUnit(unit);
                builder.insert(0, s);
            }

            num /= 1000;
            unit++;
        }

        return builder.toString().trim();
    }

    public String getNumber(int num) {
        StringBuilder res = new StringBuilder();
        // 123
        int h = num / 100;
        if (h != 0) {
            // 123 -> 23
            num %= 100;
            res.append(" " + getSingleWord(h) + " Hundred");
        }

        if (num > 10 && num < 20) {
            // 13
            //return res.append(" " + getTeenWord(num));
            return res.append(" " + getTeenWord(num)).toString().trim();
        } else {
            // 23 or 30
            int t = num / 10;
            if (t != 0) {
                res.append(" " + getTenWord(t));
                num %= 10;
            }
        }

        if (num > 0) {
            res.append(" " + getSingleWord(num));
        }

        return res.toString().trim();
    }

    public String getUnit(int c) {
        if (c == 0) return "";
        if (c == 1) return "Thousand";
        if (c == 2) return "Million";
        if (c == 3) return "Billion";

        return "";
    }

    public String getTeenWord(int n) {
        if (n == 11) return "Eleven";
        if (n == 12) return "Twelve";
        if (n == 13) return "Thirteen";
        if (n == 14) return "Fourteen";
        if (n == 15) return "Fifteen";
        if (n == 16) return "Sixteen";
        if (n == 17) return "Seventeen";
        if (n == 18) return "Eighteen";
        if (n == 19) return "Nineteen";

        return "";
    }

    public String getTenWord(int n) {
        if (n == 1) return "Ten";
        if (n == 2) return "Twenty";
        if (n == 3) return "Thirty";
        if (n == 4) return "Forty";
        if (n == 5) return "Fifty";
        if (n == 6) return "Sixty";
        if (n == 7) return "Seventy";
        if (n == 8) return "Eighty";
        if (n == 9) return "Ninety";

        return "";
    }

    public String getSingleWord(int n) {
        if (n == 1) return "One";
        if (n == 2) return "Two";
        if (n == 3) return "Three";
        if (n == 4) return "Four";
        if (n == 5) return "Five";
        if (n == 6) return "Six";
        if (n == 7) return "Seven";
        if (n == 8) return "Eight";
        if (n == 9) return "Nine";

        return "";
    }
}
