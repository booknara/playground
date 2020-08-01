package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter (Easy)
 * https://leetcode.com/problems/logger-rate-limiter/
 */
class Logger {
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    // T:O(1), S:O(n, the number of unique message)
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            if (timestamp - map.get(message) >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                // no update
                return false;
            }
        }

        map.put(message, timestamp);
        return true;
    }
}
