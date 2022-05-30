package com.booknara.problem.queue;

import java.util.LinkedList;

public class MyStack {
  LinkedList<Integer> q;
  int top;

  public MyStack() {
    q = new LinkedList<>();
    top = 0;
  }

  public void push(int x) {
    q.add(x);
    top = x;
  }

  public int pop() {
    int size = q.size();
    while (size > 1) {
      top = q.removeFirst();
      q.addLast(top);
      size--;
    }

    return q.removeFirst();
  }

  public int top() {
    return top;
  }

  public boolean empty() {
    return q.isEmpty();
  }
}
