package com.booknara.problem.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 212. Word Search II (Hard)
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearchII {
    // Trie with Backtracking
    // T:O(4*3^L, L is the max length of words), S:O(n,  the total number of letters)
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        // input check
        if (board == null || board.length == 0
                || words == null || words.length == 0) {
            return res;
        }

        Trie root = constructTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, res);
            }
        }

        Collections.sort(res); // optional to compare result sets
        return res;
    }

    public void dfs(char[][] board, int r, int c, Trie trie, List<String> res) {
        // base case
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length) return;

        // check children
        char ch = board[r][c];
        if (ch == '#' || trie.children[ch - 'a'] == null) return;

        trie = trie.children[ch - 'a'];
        // found
        if (trie.word != null) {
            res.add(trie.word);
            trie.word = null;   // avoid duplicate results
            //return; //no return because of "bend and "benda" cases
        }

        // backtracking
        board[r][c] = '#';  // visited indicator
        dfs(board, r - 1, c, trie, res);
        dfs(board, r + 1, c, trie, res);
        dfs(board, r, c - 1, trie, res);
        dfs(board, r, c + 1, trie, res);
        board[r][c] = ch;
    }

    public Trie constructTrie(String[] words) {
        Trie root = new Trie();

        for (String w: words) {
            Trie cur = root;
            for (char c: w.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Trie();
                }

                cur = cur.children[c - 'a'];
            }

            cur.word = w;
        }

        return root;
    }

    static class Trie {
        String word;
        Trie[] children;
        Trie() {
            this.children = new Trie[26];
        }
    }
}
