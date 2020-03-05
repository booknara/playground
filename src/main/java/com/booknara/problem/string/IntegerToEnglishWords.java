package com.booknara.problem.string;

/**
 * 273. Integer to English Words (Hard)
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder builder = new StringBuilder();
        int count = 0;
        while (num > 0) {
            int mod = num % 1000;
            num /= 1000;

            if (mod != 0) {
                builder.insert(0, getWords(mod) + " " + getUnit(count));
            }

            count++;
        }

        return builder.toString().trim();
    }

    private String getUnit(int count) {
        switch (count) {
            case 0:
                return "";
            case 1:
                return "Thousand ";
            case 2:
                return "Million ";
            case 3:
                return "Billion ";
            default:
                return "";
        }
    }

    private String getWords(int num) {
        boolean start = false;
        StringBuilder builder = new StringBuilder();
        int h = num / 100;
        if (h != 0) {
            // Hundred digit
            builder.append(getSingleWord(h) + " Hundred");
            start = true;
        }

        num %= 100;
        if (num > 10 && num < 20) {
            builder.append((start ? " " : "") + getTeenWord(num) + "");
            return builder.toString();
        }

        int t = num / 10;
        if (t != 0) {
            // Ten digit
            builder.append((start ? " " : "") + getTenWord(t) + "");
            start = true;
        }

        num %= 10;
        if (num != 0) {
            //Single digit
            builder.append((start ? " " : "") + getSingleWord(num) + "");
        }

        return builder.toString();
    }

    private String getSingleWord(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return "";
        }
    }

    private String getTenWord(int num) {
        switch (num) {
            case 1:
                return "Ten";
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
            default:
                return "";
        }
    }

    private String getTeenWord(int num) {
        switch (num) {
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            default:
                return "";
        }
    }
}
