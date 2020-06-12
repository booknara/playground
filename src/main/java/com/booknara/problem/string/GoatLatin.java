package com.booknara.problem.string;

/**
 * 824. Goat Latin (Easy)
 * https://leetcode.com/problems/goat-latin/
 */
public class GoatLatin {
    // T:O(n^2), S:O(n^2)
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        String[] sArray = S.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sArray.length; i++) {
            String word = sArray[i];
            //System.out.println(word);
            if (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' ||
                    word.charAt(0) == 'o' || word.charAt(0) == 'u' ||
                    word.charAt(0) == 'A' || word.charAt(0) == 'E' || word.charAt(0) == 'I' ||
                    word.charAt(0) == 'O' || word.charAt(0) == 'U') {
                // vowel case
                builder.append(word).append("ma");
            } else {
                // consonant case
                builder.append(word.substring(1, word.length())).append(word.charAt(0)).append("ma");
            }
            // 'a' added to the end
            for (int j = 0; j < i + 1; j++) {
                builder.append("a");
            }

            if (i != sArray.length - 1) builder.append(" ");
        }

        return builder.toString();
    }
}
