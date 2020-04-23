package com.booknara.problem.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree) (Medium)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class TrieWithHash {
    TrieNode root;
    /** Initialize your data structure here. */
    public TrieWithHash() {
        root = new TrieNode(false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode(false));
            }
            cur = cur.children.get(c);
        }
        cur.word = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }

        return cur.word;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }

        return true;
    }

    class TrieNode {
        boolean word;
        Map<Character, TrieNode> children;
        TrieNode(boolean word) {
            this.word = word;
            children = new HashMap<>();
        }
    }

}
