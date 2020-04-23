package com.booknara.problem.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. Map Sum Pairs (Medium)
 * https://leetcode.com/problems/map-sum-pairs/
 */
public class MapSumPairs {
    TrieNode root;
    Map<String,Integer> words;

    public MapSumPairs() {
        root = new TrieNode();
        words = new HashMap<>();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        int diff = 0;

        // only add diff value for exiting node. otherwise add value
        if (words.containsKey(key)) {
            diff = val- words.get(key);
        } else {
            diff = val;
        }
        words.put(key,val);
        for (char c : key.toCharArray()) {
            if (node.children[c -'a'] == null) {
                node.children[c -'a'] = new TrieNode();
            }

            node = node.children[c -'a'];
            node.val += diff;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if (node.children[c -'a'] == null) return 0;

            node = node.children[c -'a'];
        }

        return node.val;
    }

    class TrieNode{
        TrieNode[] children;
        int val;
        public TrieNode(){
            children = new TrieNode[26];
            val=0;
        }
    }
}
