package com.booknara.problem.trie;

/**
 * 211. Add and Search Word - Data structure design (Medium)
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.leaf = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode cur = root;
        return dfs(cur, word, 0);
    }

    private boolean dfs(TrieNode node, String s, int idx) {
        if (idx == s.length()) {
            return node.leaf;
        }

        char c = s.charAt(idx);
        if (c != '.') {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            return dfs(node.children[c - 'a'], s, idx + 1);
        }

        // . character
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                boolean b = dfs(node.children[i], s, idx + 1);
                if (b) return true;
            }
        }

        return false;
    }

    class TrieNode {
        final static int NODE = 26;
        boolean leaf;
        TrieNode[] children;
        TrieNode() {
            this.leaf = false;
            this.children = new TrieNode[NODE];
        }
    }
}
