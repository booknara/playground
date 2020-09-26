package com.booknara.problem.trie;

/**
 * 211. Add and Search Word - Data structure design (Medium)
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
class WordDictionary {
    Trie root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie(false);
    }

    /** Adds a word into the data structure. */
    // T:O(n*m), S:O(n*m)
    public void addWord(String word) {
        Trie cur = root;
        for (char c: word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Trie(false);
            }

            cur = cur.children[c - 'a'];
        }
        cur.word = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    // T:O(m*26^k), S:O(1)
    public boolean search(String word) {
        return search(root, word, 0);
    }

    /**
     r - b - a - d
     - d - a - d
     - m - a - d
     */
    public boolean search(Trie trie, String word, int index) {
        if (trie == null) return false;

        Trie cur = trie;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // 26 cases
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] == null) continue;

                    if (search(cur.children[j], word, i + 1)) return true;
                }

                return false;
            }

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