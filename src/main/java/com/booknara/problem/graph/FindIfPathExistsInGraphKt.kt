package com.booknara.problem.graph

/**
 * 1971. Find if Path Exists in Graph (Medium)
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 */
class FindIfPathExistsInGraphKt {
  // T:O(v + e), S:O(v)
  fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    val graph = hashMapOf<Int, ArrayList<Int>>()
    val stack = ArrayDeque<Int>()
    val visited = hashSetOf<Int>()

    // build graph
    for (edge in edges) {
      val s = edge[0]
      val e = edge[1]
      if (!graph.containsKey(s)) {
        graph[s] = ArrayList<Int>()
      }
      graph[s]?.add(e)
      if (!graph.containsKey(e)) {
        graph[e] = ArrayList<Int>()
      }
      graph[e]?.add(s)
    }

    stack.addLast(source)
    while (stack.size != 0) {
      val node = stack.removeLast()
      if (node == destination) {
        return true
      }
      if (visited.contains(node)) {
        continue
      }

      visited.add(node)
      // add neighbor nodes
      val neighbor = graph[node]
      if (neighbor != null) {
        for (nei in neighbor) {
          stack.addLast(nei)
        }
      }
    }

    return false
  }
}
