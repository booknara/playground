package com.booknara.problem.union.template;

/**
 * Optimized “disjoint set” with Path Compression and Union by Rank
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3843/
 */
public class OptimizedUnionFind {
  private final int[] root;
  private final int[] rank;

  // T:O(N)
  public OptimizedUnionFind(int size) {
    root = new int[size];
    rank = new int[size];
    for (int i = 0 ; i < size; i++) {
      root[i] = i;
      rank[i] = 1;
    }
  }

  // T:O(1)
  public int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  // T:O(1)
  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      // the smaller rank one should be a root for smaller tree depth
      if (rank[rootX] > rank[rootY]) {
        root[rootX] = root[rootY];
      } else if (rank[rootX] < rank[rootY]) {
        root[rootY] = root[rootX];
      } else {
        root[rootX] = root[rootY];
        rank[rootX]++;
      }
    }
  }

  // T:O(1)
  public boolean connected(int x, int y) {
    return find(x) == find(y);
  }

  public static void main(String[] args) throws Exception {
    OptimizedUnionFind uf = new OptimizedUnionFind(10);
    // 1-2-5-6-7 3-8-9 4
    uf.union(1, 2);
    uf.union(2, 5);
    uf.union(5, 6);
    uf.union(6, 7);
    uf.union(3, 8);
    uf.union(8, 9);
    System.out.println(uf.connected(1, 5)); // true
    System.out.println(uf.connected(5, 7)); // true
    System.out.println(uf.connected(4, 9)); // false
    // 1-2-5-6-7 3-8-9-4
    uf.union(9, 4);
    System.out.println(uf.connected(4, 9)); // true
  }
}
