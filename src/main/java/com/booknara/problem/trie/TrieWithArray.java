package com.booknara.problem.trie;

/**
 * 208. Implement Trie (Prefix Tree) (Medium)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class TrieWithArray {
    TrieNode root;
    /** Initialize your data structure here. */
    public TrieWithArray() {
        root = new TrieNode(false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(false);
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }

        return cur.word;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }

        return true;
    }

    class TrieNode {
        static final int NODE = 26;
        boolean word;
        TrieNode[] children;
        TrieNode(boolean word) {
            this.word = word;
            this.children = new TrieNode[NODE];
        }
    }
}
