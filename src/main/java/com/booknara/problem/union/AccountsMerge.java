package com.booknara.problem.union;

import java.util.*;

/**
 * 721. Accounts Merge (Medium)
 * https://leetcode.com/problems/accounts-merge/
 */
public class AccountsMerge {
    // T:O(AlogA), S:O(A), A: the total sum of the number accounts
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // input check
        if (accounts.size() == 1) return accounts;

        int n = accounts.size();
        int[] root = new int[n];
        // [0,1,2,3]
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (map.containsKey(email)) {
                    int root1 = findRoot(root, map.get(email));
                    int root2 = findRoot(root, i);
                    // union
                    if (root1 != root2) {
                        root[root2] = root1;
                    }
                } else {
                    map.put(email, i);
                }
            }
        }

        // [0,1,0,3]
        // dominant part, T:(AlogA)
        Map<Integer, TreeSet<String>> temp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = findRoot(root, i);

            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                TreeSet<String> treeSet = temp.getOrDefault(r, new TreeSet<>());
                treeSet.add(email);
                temp.put(r, treeSet);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry: temp.entrySet()) {
            List<String> list = new ArrayList<>();
            int key = entry.getKey();
            list.add(accounts.get(key).get(0)); // name
            list.addAll(entry.getValue());  // list of emails

            res.add(list);
        }

        return res;
    }

    public int findRoot(int[] root, int idx) {
        while (root[idx] != idx) {
            // path compression
            //root[idx] = root[root[idx]];
            idx = root[idx];
        }

        return idx;
    }
}
/**
 accounts = [
 0. ["John", "johnsmith@mail.com", "john00@mail.com"],
 1. ["John", "johnnybravo@mail.com"],
 2. ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 3. ["Mary", "mary@mail.com"]
 ]

 [0,1,2,3]
 [0,1,0,3]

 Map<String, Integer>
 "johnsmith@mail.com", 0
 "john00@mail.com", 0
 "johnnybravo@mail.com", 1

 "johnsmith@mail.com" 2 -> 0
 "john_newyork@mail.com" 2
 "mary@mail.com" 3

 Map<Integer, TreeSet<String>>

 [
 ["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 ["John", "johnnybravo@mail.com"],
 ["Mary", "mary@mail.com"]
 ]
 */