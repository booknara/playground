package com.booknara.problem.trie;

import java.util.HashSet;
import java.util.Set;

/**
 * 1044. Longest Duplicate Substring (Hard)
 * https://leetcode.com/problems/longest-duplicate-substring/
 */
public class LongestDuplicateSubstring {
    private String S;
    public String longestDupSubstring(String S) {
        this.S = S;
        int maxStart = 0, maxLength = 0;
        TrieNode root = new TrieNode(0, 0);
        for (int i = 1; i + maxLength < S.length(); i++) {
            int len = addNew(root, i);
            if (len > maxLength) {
                maxLength = len;
                maxStart = i;
            }
        }
        return S.substring(maxStart, maxStart + maxLength);
    }

    private int addNew(TrieNode node, int i) {
        int depth = node.depth;
        if (i + depth == S.length()) return depth;
        if (isLeaf(node)) {
            node.next = new TrieNode[26];
            node.next[getIndex(node.i, node.depth)] = new TrieNode(node.i, depth + 1);
        }
        int c = getIndex(i, node.depth);
        TrieNode x = node.next[c];
        if (x == null) {
            node.next[c] = new TrieNode(i, depth + 1);
            return depth;
        }
        return addNew(x, i);
    }

    private boolean isLeaf(TrieNode node) {
        return node.next == null;
    }

    private int getIndex(int i, int depth) {
        return S.charAt(i + depth) - 'a';
    }

    static class TrieNode {
        // By storing indexes and offsets in the trie nodes, almost all string handling is avoided.
        private TrieNode[] next;
        private int i;// i indicates the start position
        private int depth;

        public TrieNode(int i, int depth) {
            this.i = i;
            this.depth = depth;
        }
    }

    // T:O(n*logn), S:O(n)
    // Binary search, Rabin-Karp algorithm
    public String longestDupSubstring1(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        // convert String S -> int[] num (0 ~ 25, lowercase)
        int[] nums = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            nums[i] = S.charAt(i) - 'a';
        }
        int expo = 26;
        long mod = (long) Math.pow(2, 32);

        int left = 1, right = S.length();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (search(mid, expo, mod, S.length(), nums) != -1) left = mid + 1;
            else right = mid - 1;
        }

        int start = search(left - 1, expo, mod, S.length(), nums);

        return S.substring(start, start + left - 1);
    }

    public int search(int len, int expo, long mod, int totalLen, int[] nums) {
        long hash = 0;
        // compute the inital hash value
        for (int i = 0; i < len; i++) {
            hash = (hash * expo + nums[i]) % mod;
        }

        Set<Long> seen = new HashSet<>();
        seen.add(hash);

        long aL = 1;
        for (int i = 0; i < len; i++) {
            aL = (aL * expo) % mod;
        }
        //System.out.println(aL);
        // compute the new hash value by moving a character
        for (int start = 1; start < totalLen - len + 1; start++) {
            hash = (hash * expo - nums[start - 1] * aL % mod + mod) % mod;
            hash = (hash + nums[start + len - 1]) % mod;
            if (seen.contains(hash)) return start;
            seen.add(hash);
        }

        return -1;
    }
}
