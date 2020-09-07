package com.booknara.problem.trie;

/**
 * 211. Add and Search Word - Data structure design (Medium)
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    // T:O(n*m), S:O(n*m)
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }

        // leaf node is true which means word
        cur.word = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    // T:O(m*26^k), S:O(1)
    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode cur) {
        if (cur == null) return false;

        for (int i = 0; i < word.length(); i++) {
            // there are three cases
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode n: cur.children) {
                    if (search(word.substring(i + 1), n)) return true;
                }
                return false;
            }

            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }

        return cur.word;
    }

    static class TrieNode {
        final int NODES = 26;
        boolean word;
        TrieNode[] children;
        TrieNode() {
            this.word = false;
            this.children = new TrieNode[NODES];
        }
    }
}
/**
 WordDictionary wordDictionary = new WordDictionary();
 wordDictionary.addWord("bad");
 wordDictionary.addWord("dad");
 wordDictionary.addWord("mad");
 wordDictionary.search("pad"); // return False
 wordDictionary.search("bad"); // return True
 wordDictionary.search(".ad"); // return True
 wordDictionary.search("b.."); // return True

 Input character: only 26 alphabet (a~z)
 Method: Using Trie
 Root
 b    d    m
 a    a    a
 d(T) d(T) d(T)

 ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]

 */
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */