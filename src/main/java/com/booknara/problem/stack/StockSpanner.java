package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 901. Online Stock Span (Medium)
 * https://leetcode.com/problems/online-stock-span/
 */
class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            res += stack.pop()[1];
        }

        stack.push(new int[]{price, res});
        return res;
    }
}

//public class StockSpanner {
//    List<Integer> prices;
//    Stack<Integer> stack;
//    int idx = 0;
//    public StockSpanner() {
//        prices = new ArrayList<>();
//        // store index
//        stack = new Stack<>();
//    }
//
//    public int next(int price) {
//        int res;
//        if (stack.isEmpty()) {
//            res = 1;
//        } else {
//            while (!stack.isEmpty()) {
//                int last = stack.peek();
//                if (prices.get(last) > price) {
//                    break;
//                }
//                stack.pop();
//            }
//
//            if (stack.isEmpty()) {
//                res = idx + 1;
//            } else {
//                res = idx - stack.peek();
//            }
//
//        }
//
//        prices.add(price);
//        stack.push(idx++);
//
//        return res;
//    }
//}
