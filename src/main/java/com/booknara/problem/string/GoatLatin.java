package com.booknara.problem.string;

/**
 * 824. Goat Latin (Easy)
 * https://leetcode.com/problems/goat-latin/
 */
public class GoatLatin {
    // T:O(n^2), S:O(n^2)
    public String toGoatLatin(String S) {
        // input check (no word)
        if (S == null || S.length() == 0) return "";

        //String[] array = S.split(" ");
        String[] array = S.split("\\s+");

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            // each word
            // first character handling
            if (isVowel(array[i].charAt(0))) {
                // Vowel
                res.append(array[i]);
            } else {
                // Consonant
                res.append(array[i].substring(1, array[i].length()));
                res.append(array[i].charAt(0));
            }
            res.append("ma");

            // extra "a"
            for (int j = 0; j < i + 1; j++) {
                res.append("a");
            }
            // space
            res.append(" ");
        }

        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public boolean isVowel(char c) {
        char lower = Character.toLowerCase(c);
        return (lower == 'a' || lower == 'e'
                || lower == 'i' || lower == 'o' || lower == 'u');
    }
}

/**
 A sentence S is given, composed of words separated by spaces.
 Each word consists of lowercase and uppercase letters only.

 We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

 The rules of Goat Latin are as follows:

 1. If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 apple -> applema (append "ma" at the end)

 2. If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 goat -> oatma (remove "g" and append "g" and ma")

 3. Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.

 Return the final sentence representing the conversion from S to Goat Latin.

 "I speak Goat Latin"
 -> "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

 Input: string
 Output: string

 */