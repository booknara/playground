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
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }

        String[] name = new String[accounts.size()];

        // Key: Email, Value: Index
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            name[i] = account.get(0);

            for (int j = 1; j < account.size(); j++) { // j = 0 : name
                String email = account.get(j);
                if (map.containsKey(email)) {
                    int parentIdx = map.get(email);
                    int root1 = findRoot(root, parentIdx);
                    int root2 = findRoot(root, i);
                    if (root1 != root2) {
                        root[root2] = root[root1];
                    }
                } else {
                    map.put(email, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> sortedMap = new HashMap<>();
        for (int i = 0; i < root.length; i++) {
            int parentIndex = findRoot(root, i);
            TreeSet<String> tree = sortedMap.getOrDefault(parentIndex, new TreeSet<>());
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                tree.add(list.get(j));
            }
            sortedMap.put(parentIndex, tree);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> email: sortedMap.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(name[email.getKey()]);
            list.addAll(email.getValue());
            res.add(list);
        }

        return res;
    }

    public void union(int[] root, int a, int b) {
        root[findRoot(root, a)] = root[findRoot(root, b)];
    }

    public int findRoot(int[] root, int x) {
        if (x != root[x]) {
            root[x] = findRoot(root, root[x]);
        }
        return root[x];
    }
}
/**
 accounts =
 [
 ["John", "johnsmith@mail.com", "john00@mail.com"],
 ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 ["John", "johnnybravo@mail.com"],
 ["Mary", "mary@mail.com"]]

 [0,1,2,3]

 [0,0,2,3]

 []

 making graph
 [
 "johnsmith@mail.com" -> 0, 1
 "john00@mail.com" -> 0
 "john_newyork@mail.com" -> 1
 "johnnybravo@mail.com" -> 2
 "mary@mail.com" -> 3
 ]
 */