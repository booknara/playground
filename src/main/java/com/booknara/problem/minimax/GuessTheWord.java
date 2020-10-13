package com.booknara.problem.minimax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 843. Guess the Word (Hard)
 * https://leetcode.com/problems/guess-the-word/
 */
public class GuessTheWord {
    // T:O(n^2*logn), S:O(n^2)
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = new ArrayList<>();
        for (String s: wordlist) {
            list.add(s);
        }

        //sort(list);
        while (true) {
            String str = getWord(list);
            int matched = master.guess(str);
            if (matched == 6) return;

            List<String> temp = new ArrayList<>();
            for (String s: list) {
                if (getEqualCount(str, s) == matched) {
                    temp.add(s);
                }
            }

            list = temp;
        }
    }

    public int getEqualCount(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) count++;
        }

        return count;
    }

    public String getWord(List<String> list) {
        // there are two approach to select a word(random or sampling)
        int random = new Random().nextInt(list.size());
        return list.get(random);
        //return list.get(0);
    }

    public void sort(List<String> list) {
        int[] bucket = new int[26];
        for (String s: list) {
            for (char c: s.toCharArray()) {
                bucket[c - 'a']++;
            }
        }

        Collections.sort(list, (s1, s2) -> {
            int value1 = 0;
            for (char c: s1.toCharArray()) {
                value1 += bucket[c - 'a'];
            }
            int value2 = 0;
            for (char c: s2.toCharArray()) {
                value2 += bucket[c - 'a'];
            }
            return Integer.compare(value2, value1);
        });
    }

    interface Master {
        int guess(String word);
    }
}
