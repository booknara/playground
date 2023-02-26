package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter (Easy)
 * https://leetcode.com/problems/logger-rate-limiter/
 */
class Logger {
  private static final int THRESHOLD = 10;
  Map<String, Integer> map;
  public Logger() {
    map = new HashMap<>();
  }

  // T: O(1), S:O(n), n: the number of unique messages
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (!map.containsKey(message)) {
      map.put(message, timestamp);
      return true;
    }

    int prevTime = map.get(message);
    if (timestamp - prevTime < THRESHOLD) {
      return false;
    }

    map.put(message, timestamp);
    return true;
  }
}
