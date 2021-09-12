package com.booknara.problem.union.template;

public class QuickFind {
  private int[] roots;

  public QuickFind(int size) {
    this.roots = new int[size];
    for (int i = 0; i < size; i++) {
      roots[i] = i;
    }
  }

  private int find(int x) {
    return roots[x];
  }

  private void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      for (int i = 0; i < roots.length; i++) {
        if (roots[i] == rootY) {
          roots[i] = rootX;
        }
      }
    }
  }

  public boolean connected(int x, int y) {
    return find(x) == find(y);
  }

  public static void main(String[] args) {
    QuickFind quickFind = new QuickFind(10);
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
