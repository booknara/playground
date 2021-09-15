package com.booknara.problem.union.template;

/**
 * Quick Union - Disjoint Set
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3840/
 */
public class QuickUnion {
  private final int[] roots;

  public QuickUnion(int size) {
    this.roots = new int[size];
    for (int i = 0; i < size; i++) {
      roots[i] = i;
    }
  }

  // O(n)
  private int find(int x) {
    while (x != roots[x]) {
      // keep on traversing root nodes
      x = roots[x];
    }
    return x;
  }

  // O(n)
  private void union(int x, int y) {
    // X(parent) - Y(child)
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      roots[rootY] = rootX;
    }
  }

  // O(n)
  public boolean connected(int x, int y) {
    return find(x) == find(y);
  }

  public static void main(String[] args) {
    QuickUnion quickFind = new QuickUnion(10);
    // 1-2-5-6-7 3-8-9 4
    quickFind.union(1, 2);
    quickFind.union(2, 5);
    quickFind.union(5, 6);
    quickFind.union(6, 7);
    quickFind.union(3, 8);
    quickFind.union(8, 9);
    System.out.println(quickFind.connected(1, 5)); // true
    System.out.println(quickFind.connected(5, 7)); // true
    System.out.println(quickFind.connected(4, 9)); // false
    // 1-2-5-6-7 3-8-9-4
    quickFind.union(9, 4);
    System.out.println(quickFind.connected(4, 9)); // true
  }
}
