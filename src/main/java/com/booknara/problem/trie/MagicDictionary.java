package com.booknara.problem.trie;

/**
 * 676. Implement Magic Dictionary (Medium)
 * https://leetcode.com/problems/implement-magic-dictionary/
 */
public class MagicDictionary {
    Trie root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Trie(false);
    }

    // T:O(n*k), n: the number of dictionary, k: the average length of all the string
    public void buildDict(String[] dictionary) {
        for (String s: dictionary) {
            buildString(s);
        }
    }

    public void buildString(String s) {
        Trie cur = root;
        for (char c: s.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Trie(false);
            }

            cur = cur.children[c - 'a'];
        }

        cur.word = true;
    }

    // T:O(26n^2), n: the number of string
    public boolean search(String searchWord) {
        Trie cur = root;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            for (int j = 0; j < 26; j++) {
                // Key point : exclude maching word or not existing word
                if (c == (char)(j + 'a') || cur.children[j] == null) continue;
                if (helper(cur.children[j], searchWord, i + 1)) return true;
            }

            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }

        return false;
    }

    public boolean helper(Trie trie, String s, int index) {
        Trie cur = trie;
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.children[c - 'a'] == null) return false;

            cur = cur.children[c - 'a'];
        }

        return cur.word;
    }

    static class Trie {
        boolean word;
        Trie[] children;

        Trie(boolean word) {
            this.word = word;
            children = new Trie[26];
        }
    }
}
