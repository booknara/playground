package com.booknara.problem.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz (Easy)
 * https://leetcode.com/problems/fizz-buzz/
 */
public class FizzBuzz {
    // T:O(n), S:(n)
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }
}
