package com.booknara.problem.array;

/**
 * 900. RLE Iterator (Medium)
 * https://leetcode.com/problems/rle-iterator/
 */
public class RLEIterator {
  int[] array;
  int index;
  public RLEIterator(int[] encoding) {
    array = encoding;
    index = 0;
  }

  // T:O(n), S:O(1)
  public int next(int n) {
    while (index < array.length && n > array[index]) {
      n = n - array[index];
      index +=2;
    }

    if (index >= array.length) {
      return -1;
    }
    // n < array[index]
    array[index] = array[index] - n;    // updating count
    return array[index + 1];            // return value
  }
}
/**
 [3,8,0,9,2,5] -> [8,8,8,5,5]
 [3,8,2,5] -> [8,8,8,5,5]
 0   2
 [1,8,1,5,1,4,1,7,1,3,...80....1,4] -> n: 100 -> 99
 even index -> decrement
 n -> decrement

 [3,8,2,5], [2]->[1]->[1]->[2]
 result: 8 -> 8 -> 5 -> 5
}
