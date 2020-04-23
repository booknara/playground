package com.booknara.problem.trie;

import java.util.List;

/**
 * 648. Replace Words (Medium)
 * https://leetcode.com/problems/replace-words/
 */
public class ReplaceWords {
    TrieNode root = new TrieNode();
    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0
                || sentence == null || sentence.length() == 0) {
            return sentence;
        }

        // construct trie for dict
        for (String s: dict) {
            constructTrie(s);
        }

        // replace sentence
        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String w: words) {
            builder.append(replaceWord(w));
            builder.append(" ");
        }

        return builder.toString().trim();
    }

    private String replaceWord(String s) {
        TrieNode cur = root;
        for (char c: s.toCharArray()) {
            if (cur.children[c - 'a'] == null || cur.word != null) {    // shortest
                break;
            }
            cur = cur.children[c - 'a'];
        }

        return cur.word != null ? cur.word: s;
    }

    private void constructTrie(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = s;
    }

    class TrieNode {
        final int NODE = 26;
        String word;
        TrieNode[] children;
        TrieNode() {
            this.children = new TrieNode[NODE];
        }
    }
}
