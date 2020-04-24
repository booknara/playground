package com.booknara.problem.trie;

/**
 * 720. Longest Word in Dictionary (Easy)
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */
public class LongestWordInDictionary {
    TrieNode root;
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        root = new TrieNode("");
        for (String w: words) {
            // System.out.println(w);
            insert(w);
        }

        return dfs(root);
    }

    private String dfs(TrieNode node) {
        String res = node.word;
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && node.children[i].word.length() != 0) {
                String s = dfs(node.children[i]);
                //System.out.println(s);
                if (s.length() > res.length() || (s.length() == res.length() && s.compareTo(res) < 0)) {
                    res = s;
                }
            }
        }

        return res;
    }

    private void insert(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode("");
            }
            cur = cur.children[c - 'a'];
        }

        cur.word = s;
    }

    class TrieNode {
        String word;
        TrieNode[] children;
        TrieNode(String word) {
            this.word = word;
            this.children = new TrieNode[26];
        }
    }
}
