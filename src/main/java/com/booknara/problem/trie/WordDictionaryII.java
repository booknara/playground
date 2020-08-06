package com.booknara.problem.trie;

/**
 * 211. Add and Search Word - Data structure design (Medium)
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class WordDictionaryII {
    Trie root;
    /** Initialize your data structure here. */
    public WordDictionaryII() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie current = root;
        for (char c: word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Trie();
            }
            current = current.children[c - 'a'];
        }

        current.leaf = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, Trie trie) {
        Trie current = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (current.children[j] == null) {
                        continue;
                    }

                    System.out.println((char)(j + 97));
                    if (search(word.substring(i + 1, word.length()), current.children[j])) {
                        return true;
                    }
                }

                return false;
            }

            if (current.children[c - 'a'] == null) {
                return false;
            }

            current = current.children[c - 'a'];
        }

        return current.leaf;
    }

    static class Trie {
        final int SIZE = 26;
        boolean leaf;
        Trie[] children;

        Trie() {
            leaf = false;
            children = new Trie[SIZE];
        }
    }
}
