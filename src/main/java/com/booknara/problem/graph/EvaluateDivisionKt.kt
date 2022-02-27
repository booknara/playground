package com.booknara.problem.graph

/**
 * 399. Evaluate Division (Medium)
 * https://leetcode.com/problems/evaluate-division/
 */
class EvaluateDivisionKt {
  // T:O(v+e), S:O(v+e)
  fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
    // build a graph for the equations
    val res = DoubleArray(queries.size)

    val graph = HashMap<String, ArrayList<Pair<String, Double>>>()
    for (i in equations.indices) {
      val first = equations[i][0]
      val second = equations[i][1]
      val value = values[i]
      graph.putIfAbsent(first, ArrayList())
      graph.putIfAbsent(second, ArrayList())
      graph[first]?.add(Pair(second, value))
      graph[second]?.add(Pair(first, 1.0 / value))
    }

    for (i in 0..queries.size - 1) {
      val start = queries[i][0]
      val end = queries[i][1]
      res[i] = dfs(start, end, graph, HashSet())
    }

    return res
  }

  fun dfs(start: String, end: String, graph: HashMap<String, ArrayList<Pair<String, Double>>>, visited: HashSet<String>): Double {
    if (!graph.containsKey(start) && !graph.containsKey(end)) {
      return -1.0
    }

    if (start == end) {
      return 1.0
    }

    visited.add(start)
    if (graph.containsKey(start)) {
      val list = graph.getValue(start)
      for (i in 0..list.size - 1) {
        val pair = list.get(i)
        if (!visited.contains(pair.first)) {
          val res = dfs(pair.first, end, graph, visited)
          if (res != -1.0) {
            return res * pair.second;
          }
        }
      }
    }

    return -1.0
  }
}

fun main(args: Array<String>) {
  val equations = listOf(listOf("a", "b"), listOf("b", "c"))
  val values = doubleArrayOf(2.0,3.0)
  val queries = listOf(listOf("a", "c"), listOf("b", "a"), listOf("a", "e"), listOf("a", "a"), listOf("x", "x"))
  val result = EvaluateDivisionKt().calcEquation(equations, values, queries)
  for (r in result) {
    println(r)
  }
}
