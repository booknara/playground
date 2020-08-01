package com.booknara.problem.string;

/**
 * 520. Detect Capital (Easy)
 * https://leetcode.com/problems/detect-capital/
 */
public class DetectCapital {
    // T:O(n), S:O(1)
    public boolean detectCapitalUse(String word) {
        boolean capital = true;
        boolean lowercase = true;
        boolean firstCapital = true;
        if (!(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')) {
            firstCapital = false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
                capital = false;
            }

            if (!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
                lowercase = false;
                if (i == 0) {
                    continue;
                }
                firstCapital = false;
            }
        }

        return capital || lowercase || firstCapital;
    }

    public boolean detectCapitalUse1(String word) {
        return isAllCapital(word)
                || isAllLowercase(word)
                || isOnlyFirstCapital(word);
    }

    public boolean isAllCapital(String word) {
        //return word.equals(word.toUpperCase());
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                continue;
            }
            return false;
        }

        return true;
    }

    public boolean isAllLowercase(String word) {
        // return word.equals(word.toLowerCase());
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                continue;
            }
            return false;
        }

        return true;
    }

    public boolean isOnlyFirstCapital(String word) {
        // ASCII, A:65, Z:90, a:97, z:122
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            if (word.length() == 1) {
                return true;
            }

            return isAllLowercase(word.substring(1, word.length()));
        }

        return false;
    }
}
