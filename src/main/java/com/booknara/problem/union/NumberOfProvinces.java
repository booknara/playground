package com.booknara.problem.union;

/**
 * 547. Number of Provinces (Medium)
 * https://leetcode.com/problems/number-of-provinces/
 */
public class NumberOfProvinces {
  public int findCircleNum(int[][] isConnected) {
  // Input check
  // Union & Find (Path compression, union by rank)
  int n = isConnected.length;
  int[] root = new int[n];
  int[] rank = new int[n];
  // Root & Rank initialization
  for (int i = 0; i < n; i++) {
    root[i] = i;
    rank[i] = 0;
  }

  int res = n;
  for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
      if (isConnected[i][j] == 0) {
        continue;
      }

      int rootX = find(root, i);
      int rootY = find(root, j);
      if (rootX != rootY) {
        // checking rank value
        if (rank[rootX] > rank[rootY]) {
          root[rootX] = root[rootY];
        } else if (rank[rootX] < rank[rootY]) {
          root[rootY] = root[rootX];
        } else {
          root[rootY] = root[rootX];
          rank[rootX]++;
        }
        res--;
      }
    }
  }

  return res;
}

  public int find(int[] root, int x) {
    while (x != root[x]) {
      root[x] = root[root[x]];  // path compression
      x = root[x];
    }
    return x;
  }
}
/**
 Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 Output: 2

 [1,1,0],
 [1,1,0],
 [0,0,1]

 [0,1,2]
 [0,0,2]
 [1,0,0]

 [1,0,0,1],
 [0,1,1,0],
 [0,1,1,1],
 [1,0,1,1]

 [0-3]
 [1-2]
 [2-3]
 */
