package com.booknara.problem.trie;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1032. Stream of Characters (Hard)
 * https://leetcode.com/problems/stream-of-characters/
 */
public class StreamChecker {
    Trie root = new Trie(false);
    Deque<Character> stream = new ArrayDeque<>();

    public StreamChecker(String[] words) {
        // T:O(n*m), S:(n*m)
        // build trie (reversed string)
        for (String w: words) {
            Trie cur = root;
            String reversed = new StringBuilder(w).reverse().toString();
            for (char c: reversed.toCharArray()) {
                if (cur.tries[c - 'a'] == null) {
                    cur.tries[c - 'a'] = new Trie(false);
                }
                cur = cur.tries[c - 'a'];
            }

            // last character makes true(word)
            cur.word = true;
        }
    }

    // T:O(m, the length of string), S:O(m)
    public boolean query(char letter) {
        stream.addFirst(letter);

        Trie cur = root;
        for (char c: stream) {
            // Key point
            if (cur.word) return true;

            if (cur.tries[c - 'a'] == null) return false;

            cur = cur.tries[c - 'a'];
        }

        return cur.word;
    }

    static class Trie {
        boolean word;
        Trie[] tries;
        Trie(boolean word) {
            this.word = word;
            this.tries = new Trie[26];
        }
    }
}
